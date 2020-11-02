package com.company.exceptions;

import static com.company.messages.ExceptionMessages.INVALID_ID_MESSAGE;

public class InvalidIdException extends RuntimeException {
    @Override
    public String getMessage() {
        return INVALID_ID_MESSAGE;
    }
}