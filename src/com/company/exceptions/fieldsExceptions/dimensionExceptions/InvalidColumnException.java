package com.company.exceptions.fieldsExceptions.dimensionExceptions;


/**
 * The type Invalid column exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidColumnException extends InvalidDimensionException {

    /**
     * @return the message of the exception
     * @see InvalidDimensionException#getMessage()
     */
    @Override
    public String getMessage() {
        String message = super.getMessage();
        return message.replace("dimension", "column");
    }
}
