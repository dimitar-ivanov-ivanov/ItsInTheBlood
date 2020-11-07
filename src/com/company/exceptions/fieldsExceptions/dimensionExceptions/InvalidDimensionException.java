package com.company.exceptions.fieldsExceptions.dimensionExceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;


/**
 * The type Invalid dimension exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidDimensionException extends RuntimeException {

    /**
     * @return the exception message
     * @see ExceptionMessages#INVALID_DIMENSION_MESSAGE
     * @see InputDataRestrictions#MIN_DIMENSION
     * @see InputDataRestrictions#MAX_DIMENSION
     */
    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_DIMENSION_MESSAGE,
                InputDataRestrictions.MIN_DIMENSION,
                InputDataRestrictions.MAX_DIMENSION);
    }
}
