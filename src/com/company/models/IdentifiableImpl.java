package com.company.models;

import com.company.exceptions.fieldsExceptions.InvalidIdException;
import com.company.interfaces.Identifiable;
import com.company.validators.StringValidator;

public abstract class IdentifiableImpl implements Identifiable {
    private final String ID_PATTERN = "^\\b[A-Z]+[a-zA-Z0-9]*[A-Z0-9]+\\b$";

    private String id;

    protected IdentifiableImpl(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        if (!StringValidator.validateStringWithPatter(id, ID_PATTERN)) {
            throw new InvalidIdException();
        }
        this.id = id;
    }
}
