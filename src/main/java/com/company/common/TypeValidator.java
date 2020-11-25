package com.company.common;

import java.lang.reflect.Field;

/**
 * The type Type validator.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class TypeValidator {

    /**
     * Equal field types boolean.
     *
     * @param first  the first type
     * @param second the second type
     * @return true if both types match
     */
    public static boolean checkIfFieldTypesAreEqual(Field first, Field second) {
        return first.getType().equals(second.getType());
    }
}
