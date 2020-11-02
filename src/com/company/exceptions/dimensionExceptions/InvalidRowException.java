package com.company.exceptions.dimensionExceptions;

public class InvalidRowException extends InvalidDimensionException {
    @Override
    public String getMessage() {
        String message = super.getMessage();
        String replacedString = message.replace("dimension", "row");
        return replacedString;
    }
}
