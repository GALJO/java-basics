package com.janek.basics.math;

import com.janek.basics.CalcGold;

import static com.janek.basics.CalcGold.VALIDATION_EXIT_CODE;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;

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
     * Checking if number even
     *
     * @param number number we want to check
     * @return true or false
     */
    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checking if string is number
     *
     * @param text string we want to check
     * @return true or false
     */
    public static boolean isNumber(String text) {
        try {
            parseDouble(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
