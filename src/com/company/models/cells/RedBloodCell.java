package com.company.models.cells;

import com.company.common.NumberValidator;
import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidVelocityException;
import com.company.models.Cell;

/**
 * Represents the  Red blood cell.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class RedBloodCell extends BloodCell {

    private int velocity;

    /**
     * Instantiates a new Red blood cell.
     *
     * @param id          the id
     * @param health      the health
     * @param positionRow the position row
     * @param positionCol the position col
     * @param velocity    the velocity
     * @see BloodCell
     */
    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        setVelocity(velocity);
    }

    /**
     * Set the velocity of the cell
     *
     * @param velocity the velocity of the cell
     */
    private void setVelocity(int velocity) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (velocity, InputDataRestrictions.MIN_VELOCITY, InputDataRestrictions.MAX_VELOCITY)) {
            throw new InvalidVelocityException();
        }
        this.velocity = velocity;
    }

    /**
     * Get the energy of the cell
     *
     * @return the energy which is formed by the summation of velocity and health
     * @see Cell#getEnergy()
     */
    @Override
    public int getEnergy() {
        return super.getEnergy() + velocity;
    }

    @Override
    public String toString() {
        return super.toString() + " | Velocity " + velocity + " | Energy " + getEnergy();
    }
}
