package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.dimensionExceptions.InvalidRowException;
import com.company.interfaces.Cellular;
import com.company.interfaces.Clusterable;
import com.company.validators.NumberValidator;

public class Cluster extends Identifiable implements Clusterable {
    private int rows;
    private int cols;
    private Cellular[][] cells;

    public Cluster(String id, int rows, int cols) {
        super(id);
        setRows(rows);
        setCols(cols);
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
        this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("----Cluster " + getId() + "\n");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j] != null) {
                    builder.append(cells[i][j] + "\n");
                }
            }
        }

        builder.delete(builder.length() - 2, builder.length());

        return builder.toString();
    }
}
