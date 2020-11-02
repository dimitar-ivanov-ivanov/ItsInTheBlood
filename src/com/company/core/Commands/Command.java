package com.company.core.Commands;

public abstract class Command {
    String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
