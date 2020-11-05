package com.company.common;

public class NumberValidator {

    public static boolean checkNumberLowerThan(double num, double upperRange) {
        return num < upperRange;
    }

    public static boolean checkNumberInRangeInclusive(double num, double lower, double upper) {
        return num >= lower && num <= upper;
    }

    public static boolean checkNumberInRangeExclusive(double num, double lower, double upper) {
        return num > lower && num < upper;
    }

    public static boolean checkNumberNotInRangeInclusive(double num, double lower, double upper) {
        return num <= lower || num >= upper;
    }

    public static boolean checkNumberNotInRangeExclusive(double num, double lower, double upper) {
        return num < lower || num > upper;
    }
}
