package com.company.models.microbes;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidVirulenceException;
import com.company.models.Cell;
import com.company.common.NumberValidator;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        setVirulence(virulence);
    }

    private void setVirulence(int virulence) {
        if (NumberValidator.checkNumberNotInRangeExclusive
                (virulence, InputDataRestrictions.MIN_VIRULENCE, InputDataRestrictions.MAX_VIRULENCE)) {
            throw new InvalidVirulenceException();
        }
        this.virulence = virulence;
    }

    @Override
    public int getEnergy() {
        return getHealth() + virulence;
    }

    @Override
    public String toString() {
        return super.toString() + " | Virulence " + virulence + " | Energy " + getEnergy();
    }
}
