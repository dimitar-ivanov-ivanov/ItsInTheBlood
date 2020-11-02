package com.company.exceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

public class InvalidVelocityException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_VELOCITY_MESSAGE,
                InputDataRestrictions.MIN_VELOCITY,
                InputDataRestrictions.MAX_VELOCITY);
    }
}
