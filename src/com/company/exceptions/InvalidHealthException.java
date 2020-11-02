package com.company.exceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

public class InvalidHealthException extends RuntimeException {
    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_HEALTH_MESSAGE,
                InputDataRestrictions.MIN_HEALTH,
                InputDataRestrictions.MAX_HEALTH);
    }
}
