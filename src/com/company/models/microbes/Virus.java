package com.company.models.microbes;

/**
 * Represents the Virus.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class Virus extends Microbe {
    /**
     * Instantiates a new Virus.
     *
     * @param id          the id
     * @param health      the health
     * @param positionRow the position row
     * @param positionCol the position col
     * @param virulence   the virulence
     */
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }
}
