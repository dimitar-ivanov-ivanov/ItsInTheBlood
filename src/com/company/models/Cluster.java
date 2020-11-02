package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.dimensionExceptions.InvalidRowException;
import com.company.validators.NumberValidator;

public class Cluster extends Identifiable {
    private int rows;
    private int cols;
    private Cell[][] cells;

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
}
