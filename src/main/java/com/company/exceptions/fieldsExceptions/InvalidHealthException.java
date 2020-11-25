package com.company.exceptions.fieldsExceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

/**
 * The type Invalid health exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidHealthException extends RuntimeException {

    /**
     * Gets the message of the exception
     *
     * @return exception messege
     * @see ExceptionMessages#INVALID_HEALTH_MESSAGE
     * @see InputDataRestrictions#MIN_HEALTH
     * @see InputDataRestrictions#MAX_HEALTH
     */
    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_HEALTH_MESSAGE,
                InputDataRestrictions.MIN_HEALTH,
                InputDataRestrictions.MAX_HEALTH);
    }
}
