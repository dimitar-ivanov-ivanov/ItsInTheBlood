package com.company.common;


/**
 * The type Number validator.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class NumberValidator {

    /**
     * In range inclusive boolean.
     *
     * @param num   the num to be checked
     * @param lower the lower limit
     * @param upper the upper limit
     * @return true if in range
     */
    public static boolean checkNumberInRangeInclusive(double num, double lower, double upper) {
        return num >= lower && num <= upper;
    }

    /**
     * In range exclusive boolean.
     *
     * @param num   the num to be checked
     * @param lower the lower limit
     * @param upper the upper limit
     * @return true if in range
     */
    public static boolean checkNumberInRangeExclusive(double num, double lower, double upper) {
        return num > lower && num < upper;
    }

    /**
     * Not in range inclusive boolean.
     *
     * @param num   the num to be checked
     * @param lower the lower limit
     * @param upper the upper limit
     * @return true if in range
     */
    public static boolean checkNumberNotInRangeInclusive(double num, double lower, double upper) {
        return num <= lower || num >= upper;
    }

    /**
     * Not in range exclusive boolean.
     *
     * @param num   the num to be checked
     * @param lower the lower limit
     * @param upper the upper limit
     * @return true if in range
     */
    public static boolean checkNumberNotInRangeExclusive(double num, double lower, double upper) {
        return num < lower || num > upper;
    }
}
