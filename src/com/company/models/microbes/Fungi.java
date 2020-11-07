package com.company.models.microbes;

import com.company.models.Cell;

/**
 * Represents the Fungi.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class Fungi extends Microbe {
    /**
     * Instantiates a new Fungi.
     *
     * @param id          the id
     * @param health      the health
     * @param positionRow the position row
     * @param positionCol the position col
     * @param virulence   the virulence
     */
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    /**
     * Get the energy of the cell
     *
     * @return the energy which is formed by the summation of virulence and health divided by 4
     * @see Microbe#getEnergy()
     */
    @Override
    public int getEnergy() {
        return super.getEnergy() / 4;
    }
}
