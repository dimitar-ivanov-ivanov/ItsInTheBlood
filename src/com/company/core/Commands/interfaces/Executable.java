package com.company.core.commands.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

/**
 * The interface Executable.
 * All commands must implement this interface
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public interface Executable {

    /**
     * Execute.
     *
     * @return message for successful execution
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InstantiationException    the instantiation exception
     * @throws ExecutionControl.NotImplementedException   the not implemented exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException    the class not found exception
     */
    String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException;
}
