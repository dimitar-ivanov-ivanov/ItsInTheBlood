package com.company.exceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

/**
 * The type Invalid virulence exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidVirulenceException extends RuntimeException {

    /**
     * Get the exception message
     *
     * @return the exception message
     * @see ExceptionMessages#INVALID_VIRULENCE_MESSAGE
     * @see InputDataRestrictions#MIN_VIRULENCE
     * @see InputDataRestrictions#MAX_VIRULENCE
     */
    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_VIRULENCE_MESSAGE,
                InputDataRestrictions.MIN_VIRULENCE,
                InputDataRestrictions.MAX_VIRULENCE);
    }
}
