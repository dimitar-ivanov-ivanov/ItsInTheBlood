package com.company.exceptions.dimensionExceptions;

public class InvalidColumnException extends InvalidDimensionException {
    @Override
    public String getMessage() {
        String message = super.getMessage();
        String replacedString = message.replace("dimension", "column");
        return replacedString;
    }
}
