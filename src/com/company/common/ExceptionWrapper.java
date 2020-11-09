package com.company.common;

import com.company.core.commands.Command;
import com.company.exceptions.InputFailureException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.exceptions.modelsExceptions.MissingException;
import com.company.core.commands.interfaces.Executable;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

/**
 * The type Exception wrapper.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class ExceptionWrapper {

    /**
     * The Executable.
     */
    Executable executable;

    /**
     * Instantiates a new Exception wrapper.
     *
     * @param executable the executable
     */
    public ExceptionWrapper(Executable executable) {
        this.executable = executable;
    }

    /**
     * Run the executable and if it throws any of the listed exceptions throw a custom InputFailure exception.
     *
     * @return the string of the executable
     * @throws com.company.exceptions.InputFailure when one of the listed exceptions is thrown
     * @see Executable#execute()
     */
    public String runExecutable() {

        try {
            return executable.execute();
        } catch (InstantiationException |
                InvocationTargetException |
                NoSuchMethodException |
                IllegalAccessException |
                ExecutionControl.NotImplementedException |
                ClassNotFoundException |
                AlreadyExistsException |
                MissingException e) {
            throw new InputFailureException(e.getMessage());
        }
    }
}
