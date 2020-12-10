package com.company.models;

import com.company.common.NumberValidator;
import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidHealthException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.models.interfaces.Cellular;

/**
 * Represents the Cell
 * Main activity is to fight other cells
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see IdentifiableImpl
 * @see Cellular
 */
public abstract class Cell extends IdentifiableImpl implements Cellular {

    private int health;

    /**
     * Represents the row in the cluster in which this cell is included
     */
    private int positionRow;

    /**
     * Represents the column in the cluster in which this cell is included
     */
    private int positionCol;

    /**
     * Represents whether the cell has been attacked by another cell
     * It is false by default
     * If the cell has suffered an attack and survived it switches to true
     */
    private boolean fightMode;

    /**
     * Protected constructor
     *
     * @param id          the id of the cell which is handled by the class IdentifiableImpl
     * @param health      the health of the cell
     * @param positionRow the row of the cell in the cluster
     * @param positionCol the column of the cell in the cluster
     * @see IdentifiableImpl
     */
    protected Cell(String id, int health, int positionRow, int positionCol) {
        super(id);
        setHealth(health, InputDataRestrictions.MIN_HEALTH, InputDataRestrictions.MAX_HEALTH);
        setPositionRow(positionRow);
        setPositionCol(positionCol);
        setFightMode(false);
    }

    /**
     * Set fight mode of cell
     *
     * @param fightMode represent whether the cell has been fighting another cell
     */
    private void setFightMode(boolean fightMode) {
        this.fightMode = fightMode;
    }

    /**
     * Set health of cell after checking if it is in the correct range
     * Protected because we want to set the health of the other cell which the current one is fighting
     *
     * @param health     the updated health of the cell
     * @param lowerLimit the lower limit of the given health
     * @param upperLimit the upper limit of the given health
     * @throws InvalidHealthException if the health is not in the given range
     * @see #fight(Cellular)
     * @see NumberValidator#checkNumberNotInRangeExclusive(double, double, double)
     * @see InvalidHealthException#getMessage()
     */
    protected void setHealth(int health, int lowerLimit, int upperLimit) {
        if (NumberValidator.checkNumberNotInRangeExclusive(health, lowerLimit, upperLimit)) {
            throw new InvalidHealthException();
        }
        this.health = health;
    }

    /**
     * Set the row of the cell after checking if it is in the correct range
     *
     * @param positionRow the row of the cell in the cluster
     * @throws InvalidRowException if the row is not in the correct range
     * @see NumberValidator#checkNumberNotInRangeExclusive(double, double, double)
     * @see InvalidRowException#getMessage()
     * @see InputDataRestrictions#MIN_DIMENSION
     * @see InputDataRestrictions#MAX_DIMENSION
     */
    private void setPositionRow(int positionRow) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (positionRow, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidRowException();
        }
        this.positionRow = positionRow;

    }

    /**
     * Set the column of the cell if it is in the correct range
     *
     * @param positionCol the column of the cell in the cluster
     * @throws InvalidColumnException if the column is not in the correct range
     * @see NumberValidator#checkNumberNotInRangeExclusive(double, double, double)
     * @see InvalidColumnException#getMessage()
     * @see InputDataRestrictions#MIN_DIMENSION
     * @see InputDataRestrictions#MAX_DIMENSION
     */
    private void setPositionCol(int positionCol) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (positionCol, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidColumnException();
        }
        this.positionCol = positionCol;
    }

    /**
     * Get the energy of the cell
     *
     * @return the energy of the cell which on a base level is equal to the health
     */
    public int getEnergy() {
        return this.getHealth();
    }

    /**
     * Get the health of the cell
     *
     * @return health of the cell
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Check if the cell is alive
     *
     * @return a condition verifying whether the cell is alive
     */
    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    /**
     * Receive energy damage after a fight
     *
     * @param newHealth the new health for the cell after the fight
     */
    @Override
    public void receiveEnergyDamage(int newHealth) {
        setHealth(newHealth, -InputDataRestrictions.MAX_HEALTH, InputDataRestrictions.MAX_HEALTH);
    }

    /**
     * Get fightMode of the cell
     *
     * @return fightMode of the cell
     */
    protected boolean getFightMode() {
        return fightMode;
    }

    /**
     * Cell starts fighting
     */
    @Override
    public void initiateFighting() {
        setFightMode(true);
    }

    /**
     * Return the row of the cell in the cluster
     *
     * @return the row of the cell
     */
    @Override
    public int getPositionRow() {
        return positionRow;
    }

    /**
     * Return the column of the cell in the cluster
     *
     * @return the column of the cell
     */
    @Override
    public int getPositionCol() {
        return positionCol;
    }

    /**
     * Before the fight, move the current cell to the position of the other cell in cluster
     * One of them is going to survive and if the current one survives it should take the place of the other cell
     * <p>
     * If the current cell is a BloodCell it should assimilate all other cells
     * If the current cell is a Microbe it attacks every other cell
     * If the current cell is a BloodCell and has been attacked by a Microbe and survived, it fights back
     * <p>
     * After the attack if the current cell is alive its fightMode becomes true and now it is able to fight back
     *
     * @param other the other cell which the current one is going to fight
     */
    @Override
    public void fight(Cellular other) {
        moveCell(other);
        int otherRemainingHealth = this.attackOtherCell(other);
        other.receiveEnergyDamage(otherRemainingHealth);

        if (other.isAlive()) {
            this.initiateFighting();
            other.initiateFighting();
        }
    }

    /**
     * Attacks the other cell
     *
     * @param other the cell that is going to be attacked
     * @return the remaining health of the other cell after the fight
     */
    protected abstract int attackOtherCell(Cellular other);

    /**
     * Set the position in the cluster of the current cell to the position of the other cell
     *
     * @param other the cell that the current one is fighting
     */
    private void moveCell(Cellular other) {
        setPositionRow(other.getPositionRow());
        setPositionCol(other.getPositionCol());
    }

    @Override
    public String toString() {
        return "------" + this.getClass().getSimpleName() + " " + getId() + "[" + getPositionRow() + "," + getPositionCol() + "]\n" +
                "--------Health: " + health;
    }
}