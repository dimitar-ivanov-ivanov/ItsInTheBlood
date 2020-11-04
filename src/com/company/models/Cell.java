package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.InvalidHealthException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.interfaces.Cellular;
import com.company.common.NumberValidator;

public abstract class Cell extends IdentifiableImpl implements Cellular {
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        super(id);
        setHealth(health);
        setPositionRow(positionRow);
        setPositionCol(positionCol);
    }

    private void setHealth(int health) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (health, InputDataRestrictions.MIN_HEALTH, InputDataRestrictions.MAX_HEALTH)) {
            throw new InvalidHealthException();
        }
        this.health = health;
    }

    private void setPositionRow(int positionRow) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (positionRow, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidRowException();
        }
        this.positionRow = positionRow;

    }

    private void setPositionCol(int positionCol) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (positionCol, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidColumnException();
        }
        this.positionCol = positionCol;
    }

    @Override
    public int getPositionRow() {
        return positionRow;
    }

    @Override
    public int getPositionCol() {
        return positionCol;
    }

    @Override
    public String toString() {
        return "------Cell " + getId() + "[" + getPositionRow() + "," + getPositionCol() + "]\n" +
                "--------Health: " + health;
    }
}
