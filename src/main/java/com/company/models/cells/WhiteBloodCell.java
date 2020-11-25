package com.company.models.cells;

import com.company.common.NumberValidator;
import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidSizeException;
import com.company.models.Cell;

/**
 * Represents the White blood cell.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class WhiteBloodCell extends BloodCell {
    private int size;

    /**
     * Instantiates a new White blood cell.
     *
     * @param id          the id
     * @param health      the health
     * @param positionRow the position row
     * @param positionCol the position col
     * @param size        the size
     * @see BloodCell
     */
    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        setSize(size);
    }

    /**
     * Set the size of the cell
     *
     * @param size
     * @throws InvalidSizeException if the size doesn't fit the chosen range
     * @see InvalidSizeException#getMessage()
     * @see InputDataRestrictions#MIN_SIZE
     * @see InputDataRestrictions#MAX_SIZE
     */
    private void setSize(int size) {
        if (NumberValidator.checkNumberNotInRangeExclusive(size, InputDataRestrictions.MIN_SIZE, InputDataRestrictions.MAX_SIZE)) {
            throw new InvalidSizeException();
        }
        this.size = size;
    }

    /**
     * Get the energy of the cell
     *
     * @return the energy which is formed by the summation of velocity and health multiplied by two
     * @see Cell#getEnergy()
     */
    @Override
    public int getEnergy() {
        return (super.getEnergy() + size) * 2;
    }


    @Override
    public String toString() {
        return super.toString() + " | Size " + size + " | Energy " + getEnergy();
    }
}
