package com.company.exceptions.modelsExceptions;

public class MissingException extends RuntimeException {

    public MissingException() {
    }

    public MissingException(String message) {
        super(message);
    }
}
