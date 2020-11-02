package com.company.models.microbes;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.InvalidVirulenceException;
import com.company.models.Cell;
import com.company.validators.NumberValidator;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        setVirulence(virulence);
    }

    private void setVirulence(int virulence) {
        if (NumberValidator.notInRangeExclusive(virulence, InputDataRestrictions.MIN_VIRULENCE, InputDataRestrictions.MAX_VIRULENCE)) {
            throw new InvalidVirulenceException();
        }
        this.virulence = virulence;
    }
}
