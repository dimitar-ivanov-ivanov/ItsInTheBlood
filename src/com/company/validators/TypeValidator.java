package com.company.validators;

import java.lang.reflect.Field;

public class TypeValidator {

    public static boolean equalFieldTypes(Field first, Field second) {
        return first.getType().equals(second.getType());
    }
}
