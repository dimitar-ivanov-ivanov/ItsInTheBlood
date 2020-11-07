package com.company.exceptions;

/**
 * The type Input failure exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InputFailureException extends RuntimeException {

    /**
     * Instantiates a new Input failure exception.
     *
     * @param message the message
     */
    public InputFailureException(String message) {
        super(message);
    }
}
