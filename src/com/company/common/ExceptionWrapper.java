package com.company.common;

import com.company.exceptions.InputFailureException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.exceptions.modelsExceptions.MissingException;
import com.company.interfaces.Executable;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class ExceptionWrapper {

    Executable executable;

    public ExceptionWrapper(Executable executable) {
        this.executable = executable;
    }

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
