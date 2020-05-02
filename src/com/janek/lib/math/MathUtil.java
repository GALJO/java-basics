package com.janek.lib.math;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class MathUtil {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    /**
     * Adds two numbers
     */
    public static double addNumbers(double element1, double element2) {
        return element1 + element2;
    }

    /**
     * Subtracts two numbers
     */
    public static double subtractNumbers(double subtrahend, double minuend) {
        return subtrahend - minuend;
    }

    /**
     * Multiplies two numbers
     */
    public static double multiplyNumbers(double element1, double element2) {
        return element1 * element2;
    }

    /**
     * Divides two numbers
     */
    public static double divideNumbers(double dividend, double divider) {
        return dividend / divider;
    }


    /**
     * Calculates numbers
     *
     * @param one    first number
     * @param symbol mathematical operation (+ - * /)
     * @param two    second number
     * @return calculated double number
     */
    public static double doCalculation(double one, String symbol, double two) {
        switch (symbol) {
            case PLUS:
                return addNumbers(one, two);
            case MINUS:
                return subtractNumbers(one, two);
            case MULTIPLY:
                return multiplyNumbers(one, two);
            case DIVIDE:
                return divideNumbers(one, two);
            default:
                throw new IllegalArgumentException("Unsupported symbol");
        }
    }

    /**
     * Checks if the number is even
     *
     * @param number number we want to check
     * @return true if the number is even, otherwise false
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Checks if the string is a number
     *
     * @param text string we want to check
     * @return true if the string is a number, otherwise false
     */
    public static boolean isDouble(String text) {
        try {
            parseDouble(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if given text is long number
     * @param text text to check
     * @return true when number is long, otherwise false
     */
    public static boolean isLong(String text) {
        try {
            parseLong(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static double power(double base, int exponent) {
        if(exponent == 0) {
            return 0;
        }

        if(exponent == 1) {
            return base;
        }

        double power = multiplyNumbers(base, base);
        for (int i = 2; i < exponent; i++) {
            power = multiplyNumbers(power, base);
        }
        return power;
    }
}
