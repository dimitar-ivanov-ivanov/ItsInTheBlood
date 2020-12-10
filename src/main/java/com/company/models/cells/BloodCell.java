package com.company.models.cells;

import com.company.constants.InputDataRestrictions;
import com.company.models.Cell;
import com.company.models.interfaces.Cellular;

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

    /**
     * If fight mode is off this cell gains the health of the cell cell and the other cell gets killed
     * If fight mode if on this cell attack the other cell with its energy
     *
     * @param other the cell that is going to be attacked
     * @return the remaining health of the other cell
     */
    @Override
    public int attackOtherCell(Cellular other) {
        if (!getFightMode()) {
            //other gets health to 0
            //this one gets health + other health
            setHealth(getHealth() + other.getHealth(), InputDataRestrictions.MIN_HEALTH, InputDataRestrictions.MAX_HEALTH);
            return 0;
        }

        //other health gets lower by energy of this one
        return other.getHealth() - this.getEnergy();
    }
}
