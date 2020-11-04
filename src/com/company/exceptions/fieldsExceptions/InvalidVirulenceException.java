package com.company.exceptions.fieldsExceptions;

import com.company.constants.InputDataRestrictions;
import com.company.messages.ExceptionMessages;

public class InvalidVirulenceException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format(ExceptionMessages.INVALID_VIRULENCE_MESSAGE,
                InputDataRestrictions.MIN_VIRULENCE,
                InputDataRestrictions.MAX_VIRULENCE);
    }
}
