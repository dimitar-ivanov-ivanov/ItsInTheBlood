package com.company.models.cells;

import com.company.models.Cell;

/**
 * Representation of Blood cell.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public abstract class BloodCell extends Cell {
    /**
     * Instantiates a new Blood cell.
     *
     * @param id          the id
     * @param health      the health
     * @param positionRow the position row
     * @param positionCol the position col
     * @see Cell
     */
    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }
}
