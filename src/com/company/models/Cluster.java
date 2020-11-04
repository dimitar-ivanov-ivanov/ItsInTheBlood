package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.interfaces.Cellular;
import com.company.interfaces.Clusterable;
import com.company.messages.ExceptionMessages;
import com.company.messages.OutputMessages;
import com.company.validators.NumberValidator;

public class Cluster extends IdentifiableImpl implements Clusterable {
    private int rows;
    private int cols;
    private int cellsCount;
    private Cellular[][] cells;

    public Cluster(String id, int rows, int cols) {
        super(id);
        setRows(rows);
        setCols(cols);
        this.cellsCount = 0;
        this.cells = new Cell[rows][cols];
    }

    private void setRows(int rows) {
        if (NumberValidator.notInRangeExclusive(rows, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidRowException();
        }
        this.rows = rows;

    }

    private void setCols(int cols) {
        if (NumberValidator.notInRangeExclusive(cols, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidColumnException();
        }
        this.cols = cols;
    }

    @Override
    public void addCell(Cellular cell) {
        int row = cell.getPositionRow();
        int col = cell.getPositionCol();

        if (cells[row][col] == null) {
            cells[row][col] = cell;
            cellsCount++;
        } else {
            throw new AlreadyExistsException(String.format(ExceptionMessages.ALREADY_EXISTS_FAIL, "Cell", cell.getId()));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--Cells: " + cellsCount + "\n");
        builder.append("----Cluster " + getId() + "\n");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j] != null) {
                    builder.append(cells[i][j] + "\n");
                }
            }
        }
        return builder.toString();
    }
}
