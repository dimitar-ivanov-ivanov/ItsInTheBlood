package com.company.interfaces;

public interface Clustercentric extends Identifiable {

    void addCell(Cellular cell);

    int getCellsCount();

    int activate();
}
