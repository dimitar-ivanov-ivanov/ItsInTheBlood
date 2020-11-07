package com.company.exceptions.fieldsExceptions.dimensionExceptions;


/**
 * The type Invalid row exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidRowException extends InvalidDimensionException {

    /**
     * Get the exception message
     *
     * @return the exception message
     * @see InvalidDimensionException#getMessage()
     */
    @Override
    public String getMessage() {
        String message = super.getMessage();
        String replacedString = message.replace("dimension", "row");
        return replacedString;
    }
}
