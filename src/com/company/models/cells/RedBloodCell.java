package com.company.models.cells;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidVelocityException;
import com.company.common.NumberValidator;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        setVelocity(velocity);
    }

    private void setVelocity(int velocity) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (velocity, InputDataRestrictions.MIN_VELOCITY, InputDataRestrictions.MAX_VELOCITY)) {
            throw new InvalidVelocityException();
        }
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return super.toString() + " | Velocity " + velocity;
    }
}
