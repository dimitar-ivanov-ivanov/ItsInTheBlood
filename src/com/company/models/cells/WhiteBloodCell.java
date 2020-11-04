package com.company.models.cells;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidSizeException;
import com.company.validators.NumberValidator;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        setSize(size);
    }

    private void setSize(int size) {
        if (NumberValidator.notInRangeExclusive(size, InputDataRestrictions.MIN_SIZE, InputDataRestrictions.MAX_SIZE)) {
            throw new InvalidSizeException();
        }
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + " | Size " + size;
    }
}
