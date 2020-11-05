package com.company.models.cells;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidSizeException;
import com.company.common.NumberValidator;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        setSize(size);
    }

    private void setSize(int size) {
        if (NumberValidator.checkNumberNotInRangeExclusive(size, InputDataRestrictions.MIN_SIZE, InputDataRestrictions.MAX_SIZE)) {
            throw new InvalidSizeException();
        }
        this.size = size;
    }

    @Override
    public int getEnergy() {
        return (size + getHealth()) * 2;
    }

    @Override
    public String toString() {
        return super.toString() + " | Size " + size + " | Energy " + getEnergy();
    }
}
