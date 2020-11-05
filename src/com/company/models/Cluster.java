package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidDimensionException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.interfaces.Cellular;
import com.company.interfaces.Clustercentric;
import com.company.messages.ExceptionMessages;
import com.company.common.NumberValidator;

import java.util.HashMap;
import java.util.Map;

public class Cluster extends IdentifiableImpl implements Clustercentric {
    private int rows;
    private int cols;
    private int cellsCount;
    private Map<Integer, Map<Integer, Cellular>> cells;

    public Cluster(String id, int rows, int cols) {
        super(id);
        setRows(rows);
        setCols(cols);
        this.cellsCount = 0;
        this.cells = new HashMap<>();
    }

    private void setRows(int rows) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (rows, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidRowException();
        }
        this.rows = rows;
    }

    private void setCols(int cols) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (cols, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidColumnException();
        }
        this.cols = cols;
    }

    @Override
    public int getCellsCount() {
        return this.cellsCount;
    }

    @Override
    public void addCell(Cellular cell) {
        int row = cell.getPositionRow();
        int col = cell.getPositionCol();

        if (row >= rows || col >= cols) {
            throw new InvalidDimensionException();
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

    @Override
    public int activate() {
        Cellular firstCell = findCell(rows, cols);

        if (firstCell == null) {
            cellsCount = 0;
            return 0;
        }

        //find other cells and fight
        while (true) {
            Cellular nextCell = findCell(firstCell.getPositionRow(), firstCell.getPositionCol());
            if (nextCell == null) {
                break;
            }

            //remove the first cell here because when they fight the cells changes positions
            removeCell(firstCell);
            fightCell(firstCell, nextCell);
            removeCell(nextCell);

            if (isCellDead(nextCell)) {
                cells.get(nextCell.getPositionRow()).put(nextCell.getPositionCol(), firstCell);
            } else if (isCellDead(firstCell)) {
                firstCell = nextCell;
            }
        }


        //the cells either assimilates or kills other cells and and the end it's the only one left
        cellsCount = 1;
        return cellsCount;
    }

    private void fightCell(Cellular firstCell, Cellular secondCell) {

        //both cells fight until one of them dies
        while (!isCellDead(firstCell) && !isCellDead(secondCell)) {
            firstCell.fight(secondCell);
            if (!isCellDead(secondCell)) {
                //the second cell fights back
                secondCell.fight(firstCell);
            }
        }
    }

    private void removeCell(Cellular cell) {
        cells.get(cell.getPositionRow()).remove(cell.getPositionCol());
    }

    private boolean isCellDead(Cellular cell) {
        return cell.getHealth() <= 0;
    }

    private Cellular findCell(int rowRestriction, int colRestriction) {
        Cellular cell = null;

        for (Map.Entry<Integer, Map<Integer, Cellular>> rows : cells.entrySet()) {
            int row = rows.getKey();

            for (Map.Entry<Integer, Cellular> cols : rows.getValue().entrySet()) {
                int col = cols.getKey();

                if (col == colRestriction) {
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
