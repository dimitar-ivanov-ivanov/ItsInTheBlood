package com.company.core.commands;

import com.company.core.commands.interfaces.Executable;

public abstract class Command implements Executable {
    String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
