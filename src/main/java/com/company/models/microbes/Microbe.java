package com.company.models.microbes;

import com.company.common.NumberValidator;
import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidVirulenceException;
import com.company.models.Cell;

/**
 * Represents the Microbe.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public abstract class Microbe extends Cell {
    private int virulence;

    /**
     * Instantiates a new Microbe.
     *
     * @param id          the id
     * @param health      the health
     * @param positionRow the position row
     * @param positionCol the position col
     * @param virulence   the virulence
     * @see Cell
     */
    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        setVirulence(virulence);
    }

    /**
     * Set the virulence of the microbe
     *
     * @param virulence
     * @throws InvalidVirulenceException if the virulence doesn't fit in the chosen range
     * @see InvalidVirulenceException#getMessage()
     * @see InputDataRestrictions#MIN_VIRULENCE
     * @see InputDataRestrictions#MAX_VIRULENCE
     */
    private void setVirulence(int virulence) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (virulence, InputDataRestrictions.MIN_VIRULENCE, InputDataRestrictions.MAX_VIRULENCE)) {
            throw new InvalidVirulenceException();
        }
        this.virulence = virulence;
    }

    /**
     * Get the energy of the cell
     *
     * @return the energy which is formed by the summation of virulence and health
     * @see Cell#getEnergy()
     */
    @Override
    public int getEnergy() {
        return super.getEnergy() + virulence;
    }

    @Override
    public String toString() {
        return super.toString() + " | Virulence " + virulence + " | Energy " + getEnergy();
    }
}
