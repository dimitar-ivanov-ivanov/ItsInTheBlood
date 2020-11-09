package com.company.exceptions.fieldsExceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

/**
 * The type Invalid velocity exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidVelocityException extends RuntimeException {

    /**
     * Get the exception message
     *
     * @return the exception message
     * @see ExceptionMessages#INVALID_VELOCITY_MESSAGE
     * @see InputDataRestrictions#MIN_VELOCITY
     * @see InputDataRestrictions#MAX_VELOCITY
     */
    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_VELOCITY_MESSAGE,
                InputDataRestrictions.MIN_VELOCITY,
                InputDataRestrictions.MAX_VELOCITY);
    }
}
