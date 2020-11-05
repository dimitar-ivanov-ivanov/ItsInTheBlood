package com.company.interfaces;

import com.company.models.Cell;

public interface Cellular extends Identifiable {

    int getPositionRow();

    int getPositionCol();

    int getHealth();

    void fight(Cellular cell);

    //boolean getFightMode();
}
