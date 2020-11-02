package com.company.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    public static boolean validateStringWithPatter(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher idMatcher = pattern.matcher(text);
        return idMatcher.find();
    }
}
