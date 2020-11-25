package com.company.exceptions;

/**
 * The type Input failure.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InputFailure extends RuntimeException {

    /**
     * Instantiates a new Input failure.
     *
     * @param message the message
     */
    public InputFailure(String message) {
        super(message);
    }
}
