package com.company.exceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

/**
 * The type Invalid size exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidSizeException extends RuntimeException {

    /**
     * Get the exception message
     *
     * @return the exception message
     * @see ExceptionMessages#INVALID_SIZE_MESSAGE
     * @see InputDataRestrictions#MIN_SIZE
     * @see InputDataRestrictions#MAX_SIZE
     */
    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_SIZE_MESSAGE,
                InputDataRestrictions.MIN_SIZE,
                InputDataRestrictions.MAX_SIZE);
    }
}
