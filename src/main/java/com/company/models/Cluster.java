package com.company.models;

import com.company.common.NumberValidator;
import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.models.interfaces.Cellular;
import com.company.models.interfaces.Clustercentric;
import com.company.messages.ExceptionMessages;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Cluster filled with cells
 * Main activities are to add cells and get activated
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see IdentifiableImpl
 * @see Clustercentric
 */
public class Cluster extends IdentifiableImpl implements Clustercentric {

    /**
     * The total rows that can be filled with cells in the cluster
     */
    private int rows;

    /**
     * The total columns that can be filled with cells in the cluster
     */
    private int cols;

    private int cellsCount;

    /**
     * Represents the matrix of cells but since we can have a big matrix with only a few
     * cells filled we implement the matrix through an map
     *
     * @see Cellular
     */
    private final Map<Integer, Map<Integer, Cellular>> cells;

    /**
     * Public constructor
     *
     * @param id   the id of the cluster which is handled by the class IdentifiableImpl
     * @param rows the total rows of the cluster
     * @param cols the total columns of the cluster
     * @see IdentifiableImpl
     */
    public Cluster(String id, int rows, int cols) {
        super(id);
        setRows(rows);
        setCols(cols);
        this.cellsCount = 0;
        this.cells = new HashMap<>();
    }

    /**
     * Sets the row dimension if it fits within the chosen range
     *
     * @param rows the updated rows of the cluster
     * @throws InvalidRowException if row doesn't fit in range
     * @see InvalidRowException
     * @see NumberValidator#checkNumberNotInRangeExclusive
     * @see InputDataRestrictions#MIN_DIMENSION
     * @see InputDataRestrictions#MAX_DIMENSION
     */
    private void setRows(int rows) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (rows, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidRowException();
        }
        this.rows = rows;
    }

    /**
     * Sets the column dimension
     *
     * @param cols the updated cols of the cluster
     * @throws InvalidColumnException if cols doesn't fit in range
     * @see InvalidColumnException
     * @see NumberValidator#checkNumberNotInRangeExclusive
     * @see InputDataRestrictions#MIN_DIMENSION
     * @see InputDataRestrictions#MAX_DIMENSION
     */
    private void setCols(int cols) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (cols, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidColumnException();
        }
        this.cols = cols;
    }

    /**
     * The total cells count of the cluster
     *
     * @return the number of cells in the cluster
     */
    @Override
    public int getCellsCount() {
        return this.cellsCount;
    }

    /**
     * Add the cell to the cluster if its rows fit the range and the given cell in the matrix is free
     * If it fails any of these requirements throw the appropriate exception
     *
     * @param cell the cell that is going to be added to the cluster
     * @throws InvalidRowException    if the row doesn't fit in range
     * @throws InvalidColumnException if col doesn't fit in range
     * @throws AlreadyExistsException if the cell is used
     */
    @Override
    public void addCell(Cellular cell) {
        int row = cell.getPositionRow();
        int col = cell.getPositionCol();

        if (row >= rows) {
            throw new InvalidRowException();
        }

        if (col >= cols) {
            throw new InvalidColumnException();
        }

        if (!cells.containsKey(row)) {
            cells.put(row, new HashMap<>());
        }

        if (!cells.get(row).containsKey(col)) {
            cells.get(row).put(col, cell);
            cellsCount++;
        } else {
            throw new AlreadyExistsException(String.format(ExceptionMessages.ALREADY_EXISTS_FAIL, "Cell", cell.getId()));
        }
    }

    /**
     * Activate the cluster and find the first cell in the matrix
     * Choose that cell and have it go through the entire matrix either assimilating or fighting all other cells
     * After the start of the fight the first cell changes position to the position of the cell it is fighting
     * If the first cell dies its place is taken by the cell that killed it
     *
     * @return the count of cells after activation
     * @see Cell#fight(Cellular)
     */
    @Override
    public int activate() {
        Cellular firstCell = findCell(rows, cols);

        if (firstCell == null) {
            cellsCount = 0;
            return 0;
        }

        while (true) {
            Cellular nextCell = findCell(firstCell.getPositionRow(), firstCell.getPositionCol());
            if (nextCell == null) {
                break;
            }

            //remove the first cell here because when they fight the cells changes positions
            removeCell(firstCell);
            fightCell(firstCell, nextCell);
            removeCell(nextCell);

            if (!nextCell.isAlive()) {
                cells.get(nextCell.getPositionRow()).put(nextCell.getPositionCol(), firstCell);
            } else if (!firstCell.isAlive()) {
                firstCell = nextCell;
            }
        }


        //the cells either assimilates or kills other cells and and the end it's the only one left
        cellsCount = 1;
        return cellsCount;
    }

    /**
     * The cells fight until one of them dies
     * If the second cell survives after the initial attack it fights back and they fight until one of them is dead
     *
     * @param firstCell  the first cell we found in the matrix, the one that fights every other cell
     * @param secondCell the next cell that the first will be fighting
     * @see Cell#fight(Cellular)
     */
    private void fightCell(Cellular firstCell, Cellular secondCell) {
        while (firstCell.isAlive() && secondCell.isAlive()) {
            firstCell.fight(secondCell);
            if (secondCell.isAlive()) {
                //the second cell fights back
                secondCell.fight(firstCell);
            }
        }
    }

    /**
     * Remove a cell from the matrix
     *
     * @param cell the cell that is going to get removed
     */
    private void removeCell(Cellular cell) {
        cells.get(cell.getPositionRow()).remove(cell.getPositionCol());
    }

    /**
     * Find a cell depending on dimension restrictions
     *
     * @param rowRestriction the row that should be accessed
     * @param colRestriction the column that should be accessed
     * @return the cell that we find
     */
    private Cellular findCell(int rowRestriction, int colRestriction) {
        Cellular cell = null;

        for (Map.Entry<Integer, Map<Integer, Cellular>> rows : cells.entrySet()) {
            int row = rows.getKey();

            for (Map.Entry<Integer, Cellular> cols : rows.getValue().entrySet()) {
                int col = cols.getKey();

                if (row == rowRestriction && col == colRestriction) {
                    continue;
                }

                cell = cols.getValue();
                return cell;
            }
        }

        return cell;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("----Cluster " + getId() + "\n");

        for (int row = 0; row < rows; row++) {
            if (cells.containsKey(row)) {
                for (int col = 0; col < cols; col++) {
                    if (cells.get(row).containsKey(col)) {
                        builder.append(cells.get(row).get(col) + "\n");
                    }
                }
            }
        }

        return builder.toString();
    }
}
