package com.company.exceptions.modelsExceptions;


/**
 * The type Already exists exception.
 *
 * @author Dimitar ivanov
 * @since 1.4
 */
public class AlreadyExistsException extends RuntimeException {

    /**
     * Instantiates a new Already exists exception.
     */
    public AlreadyExistsException() {
    }

    /**
     * Instantiates a new Already exists exception.
     *
     * @param message the message
     */
    public AlreadyExistsException(String message) {
        super(message);
    }
}
