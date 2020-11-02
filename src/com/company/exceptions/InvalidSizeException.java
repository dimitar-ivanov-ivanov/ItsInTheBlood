package com.company.exceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

public class InvalidSizeException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_SIZE_MESSAGE,
                InputDataRestrictions.MIN_SIZE,
                InputDataRestrictions.MAX_SIZE);
    }
}
