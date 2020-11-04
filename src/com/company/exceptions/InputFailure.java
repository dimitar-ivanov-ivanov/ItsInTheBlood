package com.company.exceptions;

public class InputFailure extends RuntimeException {

    public InputFailure(String message) {
        super(message);
    }
}
