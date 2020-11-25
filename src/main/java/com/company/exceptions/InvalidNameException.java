package com.company.exceptions;

import com.company.messages.ExceptionMessages;


/**
 * The type Invalid name exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidNameException extends RuntimeException {

    /**
     * Get the exception message
     *
     * @return the exception message
     * @see ExceptionMessages#INVALID_ID_MESSAGE
     */
    @Override
    public String getMessage() {
        return ExceptionMessages.INVALID_ORGANISM_NAME_MESSAGE;
    }
}
