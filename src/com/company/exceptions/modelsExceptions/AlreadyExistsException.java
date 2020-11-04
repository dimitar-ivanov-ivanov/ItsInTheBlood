package com.company.exceptions.modelsExceptions;

import com.company.messages.ExceptionMessages;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException() {
    }

    public AlreadyExistsException(String message) {
        super(message);
    }
}
