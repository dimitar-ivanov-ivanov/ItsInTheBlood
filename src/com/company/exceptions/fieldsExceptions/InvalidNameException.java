package com.company.exceptions.fieldsExceptions;

import com.company.messages.ExceptionMessages;

public class InvalidNameException extends RuntimeException {
    @Override
    public String getMessage() {
        return ExceptionMessages.INVALID_ORGANISM_NAME_MESSAGE;
    }
}
