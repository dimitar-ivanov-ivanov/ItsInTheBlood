package com.company.core.commands;

import com.company.core.commands.interfaces.Executable;

/**
 * The type Command.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public abstract class Command implements Executable {
    /**
     * The input data.
     */
    String[] data;

    /**
     * Instantiates a new Command.
     *
     * @param data the data
     */
    public Command(String[] data) {
        this.data = data;
    }

    /**
     * Get data for the command.
     *
     * @return the data for the command
     */
    protected String[] getData() {
        return this.data;
    }
}
