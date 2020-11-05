package com.company.models;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.InvalidHealthException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.interfaces.Cellular;
import com.company.common.NumberValidator;
import com.company.models.cells.BloodCell;
import com.company.models.cells.RedBloodCell;
import com.company.models.microbes.Microbe;

public abstract class Cell extends IdentifiableImpl implements Cellular {
    private int health;
    private int positionRow;
    private int positionCol;
    private boolean fightMode;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        super(id);
        setHealth(health, InputDataRestrictions.MIN_HEALTH, InputDataRestrictions.MAX_HEALTH);
        setPositionRow(positionRow);
        setPositionCol(positionCol);
        setFightMode(false);
    }

    protected void setFightMode(boolean fightMode) {
        this.fightMode = fightMode;
    }

    protected void setHealth(int health, int lowerLimit, int upperLimit) {
        if (NumberValidator.checkNumberNotInRangeExclusive(health, lowerLimit, upperLimit)) {
            throw new InvalidHealthException();
        }
        this.health = health;
    }

    private void setPositionRow(int positionRow) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (positionRow, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidRowException();
        }
        this.positionRow = positionRow;

    }

    private void setPositionCol(int positionCol) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (positionCol, InputDataRestrictions.MIN_DIMENSION, InputDataRestrictions.MAX_DIMENSION)) {
            throw new InvalidColumnException();
        }
        this.positionCol = positionCol;
    }

    public abstract int getEnergy();

    public int getHealth() {
        return health;
    }

    @Override
    public int getPositionRow() {
        return positionRow;
    }

    @Override
    public int getPositionCol() {
        return positionCol;
    }

    @Override
    public void fight(Cellular other) {
        moveCell(other);
        if (this instanceof BloodCell && !fightMode) {
            assimilateOtherCell((Cell) other);
        } else if (this instanceof Microbe || (this instanceof BloodCell && fightMode)) {
            attackOtherCell((Cell) other);
            //for continuous fighting
            initiateFighting((Cell) other);
        }
    }

    private void moveCell(Cellular other) {
        setPositionRow(other.getPositionRow());
        setPositionCol(other.getPositionCol());
    }

    private void assimilateOtherCell(Cell other) {
        int newHealthCurrent = this.getHealth() + other.getHealth();
        this.setHealth(newHealthCurrent, InputDataRestrictions.MIN_HEALTH, InputDataRestrictions.MAX_HEALTH);

        //the other cell dies
        int newHealthOther = 0;
        other.setHealth(newHealthOther, -1, InputDataRestrictions.MAX_HEALTH);
    }

    private void attackOtherCell(Cell other) {
        int newHealthOther = other.getHealth() - this.getEnergy();
        //the current energy may be very high so we give the lower limit to the minus energy because it may be negative
        other.setHealth(newHealthOther, -this.getEnergy(), InputDataRestrictions.MAX_HEALTH);
    }

    private void initiateFighting(Cell other) {
        this.setFightMode(true);
        other.setFightMode(true);
    }

    @Override
    public String toString() {
        return "------Cell " + getId() + "[" + getPositionRow() + "," + getPositionCol() + "]\n" +
                "--------Health: " + health;
    }
}