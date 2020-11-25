package com.company.models;

import com.company.common.StringValidator;
import com.company.exceptions.fieldsExceptions.InvalidIdException;
import com.company.models.interfaces.Identifiable;

/**
 * Represents the Identifiable
 * All classes that have id must inherit this class
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */

public abstract class IdentifiableImpl implements Identifiable {

    /**
     * Represents the pattern for the id
     * It should start with capital letter and end with capital letter or number
     * and everything is between is alphanumerical
     */
    private final String ID_PATTERN = "^\\b[A-Z]+[a-zA-Z0-9]*[A-Z0-9]+\\b$";

    private String id;

    /**
     * Protected constructor
     *
     * @param id the id of the object
     */
    protected IdentifiableImpl(String id) {
        setId(id);
    }

    /**
     * Get the objects' id
     *
     * @return the id of the object
     */
    public String getId() {
        return id;
    }

    /**
     * Set the object's id if it fits the pattern
     *
     * @param id the updated id of the object
     * @see StringValidator#validateStringWithPattern(String, String)
     */
    private void setId(String id) {
        if (!StringValidator.validateStringWithPattern(id, ID_PATTERN)) {
            throw new InvalidIdException();
        }
        this.id = id;
    }
}
