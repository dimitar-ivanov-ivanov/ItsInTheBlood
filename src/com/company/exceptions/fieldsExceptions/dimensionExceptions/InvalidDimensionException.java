package com.company.exceptions.fieldsExceptions.dimensionExceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

public class InvalidDimensionException extends RuntimeException {
    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_DIMENSION_MESSAGE,
                InputDataRestrictions.MIN_DIMENSION,
                InputDataRestrictions.MAX_DIMENSION);
    }
}
