package com.janek.basics.math;

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
}
