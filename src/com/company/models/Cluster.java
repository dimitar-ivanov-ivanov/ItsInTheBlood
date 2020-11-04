package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidDimensionException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.interfaces.Cellular;
import com.company.interfaces.Clustecentric;
import com.company.messages.ExceptionMessages;
import com.company.common.NumberValidator;

import java.util.HashMap;
import java.util.Map;

public class Cluster extends IdentifiableImpl implements Clustecentric {
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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--Cells: " + cellsCount + "\n");
        builder.append("----Cluster " + getId() + "\n");

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (cells.containsKey(row) && cells.get(row).containsKey(col)) {
                    builder.append(cells.get(row).get(col) + "\n");
                }
            }
        }

        return builder.toString();
    }
}
