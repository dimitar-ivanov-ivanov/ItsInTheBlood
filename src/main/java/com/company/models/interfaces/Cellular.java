package com.company.models.interfaces;

/**
 * Objects of class Cell must implement this interface
 * Extend the Identifiable interface because the cell should contain id.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see Identifiable
 */
public interface Cellular extends Identifiable {

    /**
     * Return the row of the cell in the cluster
     *
     * @return the row of the cell
     */
    int getPositionRow();

    /**
     * Return the column of the cell in the cluster
     *
     * @return the column of the cell
     */
    int getPositionCol();

    /**
     * Return the health of the cell that can range from 0 to 500
     *
     * @return the health of the cell
     */
    int getHealth();

    /**
     * Turn on the fight mode of the cell
     */
    void initiateFighting();

    /**
     * Return a condition to find out whether the cell is alive
     *
     * @return the verification of the condition
     */
    boolean isAlive();

    /**
     * After a fight take damage
     */
    void receiveEnergyDamage(int energy);

    /**
     * The current cell fights another cell and depending on it's kind it can either be assimilated or just damaged
     *
     * @param cell the cell which the current cell will fight against
     */
    void fight(Cellular cell);
}
