package com.company.models.microbes;

public class Fungi extends Bacteria {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return super.getEnergy() / 4;
    }
}
