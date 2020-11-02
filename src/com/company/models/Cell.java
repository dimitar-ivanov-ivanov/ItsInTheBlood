package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.InvalidHealthException;
import com.company.exceptions.dimensionExceptions.InvalidRowException;
import com.company.validators.NumberValidator;


public abstract class Cell extends Identifiable {
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        super(id);
        setHealth(health);
        setPositionRow(positionRow);
        setPositionCol(positionCol);
    }

    private void setHealth(int health) {
        if (NumberValidator.notInRangeExclusive(health, InputDataRestrictions.MIN_HEALTH, InputDataRestrictions.MAX_HEALTH)) {
            throw new InvalidHealthException();
        }
        this.health = health;
    }

    private void setPositionRow(int positionRow) {
        if (NumberValidator.notInRangeExclusive(positionRow, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidRowException();
        }
        this.positionRow = positionRow;

    }

    private void setPositionCol(int positionCol) {
        if (NumberValidator.notInRangeExclusive(positionCol, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidColumnException();
        }
        this.positionCol = positionCol;
    }

    @Override
    public String toString() {
        return "Health " + health;
    }
}
