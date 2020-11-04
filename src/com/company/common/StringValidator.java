package com.company.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    public static boolean validateStringWithPattern(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher idMatcher = pattern.matcher(text);
        return idMatcher.find();
    }
}
