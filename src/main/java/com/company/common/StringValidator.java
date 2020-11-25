package com.company.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type String validator.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class StringValidator {

    /**
     * Validate string with patter boolean.
     *
     * @param text  the text
     * @param regex the regex pattern
     * @return true if the text matches the pattern
     */
    public static boolean validateStringWithPattern(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher idMatcher = pattern.matcher(text);
        return idMatcher.find();
    }
}
