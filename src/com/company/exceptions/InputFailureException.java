package com.company.exceptions;

public class InputFailureException extends RuntimeException {

    public InputFailureException(String message) {
        super(message);
    }
}
