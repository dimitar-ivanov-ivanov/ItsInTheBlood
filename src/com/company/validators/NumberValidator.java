package com.company.validators;

public class NumberValidator {

    public static boolean inRangeInclusive(double num, double lower, double upper) {
        return num >= lower && num <= upper;
    }

    public static boolean inRangeExclusive(double num, double lower, double upper) {
        return num > lower && num < upper;
    }

    public static boolean notInRangeInclusive(double num, double lower, double upper) {
        return num <= lower || num >= upper;
    }

    public static boolean notInRangeExclusive(double num, double lower, double upper) {
        return num < lower || num > upper;
    }
}
