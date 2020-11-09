package com.company.exceptions.fieldsExceptions;

import static com.company.messages.ExceptionMessages.INVALID_ID_MESSAGE;

/**
 * The type Invalid id exception.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class InvalidIdException extends RuntimeException {
    /**
     * Get the exception message
     *
     * @return the exception message
     * @see com.company.messages.ExceptionMessages#INVALID_ID_MESSAGE
     */
    @Override
    public String getMessage() {
        return INVALID_ID_MESSAGE;
    }
}
