package com.company.exceptions.modelsExceptions;

/**
 * The type Missing exception.
 *
 * @author Dimitar ivanov
 * @since 1.4
 */
public class MissingException extends RuntimeException {


    /**
     * Instantiates a new Missing exception.
     */
    public MissingException() {
    }

    /**
     * @param message the message of the exception
     */
    public MissingException(String message) {
        super(message);
    }
}
