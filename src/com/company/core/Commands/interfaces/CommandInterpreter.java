package com.company.core.commands.interfaces;

/**
 * The interface Command interpreter.
 * All classes that interpret commands must implement this class
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public interface CommandInterpreter {

    /**
     * Interpret command by given data and name.
     *
     * @param data        the data
     * @param commandName the command name
     * @return the executable
     */
    Executable interpretCommand(String[] data, String commandName);
}
