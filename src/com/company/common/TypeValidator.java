package com.company.common;

import java.lang.reflect.Field;

public class TypeValidator {

    public static boolean checkIfFieldTypesAreEqual(Field first, Field second) {
        return first.getType().equals(second.getType());
    }
}
