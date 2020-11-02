package com.company.models;

import com.company.exceptions.InvalidIdException;
import com.company.validators.StringValidator;

public abstract class Identifiable {
    private final String ID_PATTERN = "^\\b[A-Z]+[a-zA-Z0-9]*[A-Z0-9]+\\b$";

    private String id;

    protected Identifiable(String id) {
        this.id = id;
    }

    protected String getId() {
        return id;
    }

    private void setId(String id) {
        if (!StringValidator.validateStringWithPatter(id, ID_PATTERN)) {
            throw new InvalidIdException();
        }
        this.id = id;
    }
}
