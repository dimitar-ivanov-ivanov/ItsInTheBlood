package com.company.models.microbes;

/**
 * Represents the Bacteria.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class Bacteria extends Microbe {
    /**
     * Instantiates a new Bacteria.
     *
     * @param id          the id
     * @param health      the health
     * @param positionRow the position row
     * @param positionCol the position col
     * @param virulence   the virulence
     * @see Microbe
     */
    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    /**
     * Get the energy of the bacteria
     *
     * @return the energy which is formed by the base energy divided by 3
     * @see Microbe#getEnergy()
     */
    @Override
    public int getEnergy() {
        return super.getEnergy() / 3;
    }
}
