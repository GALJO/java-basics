package com.janek.calculator;

import static com.janek.lib.math.MathUtil.*;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;

public class CalcPremium {
    private static final String INPUT_PLUS_SYMBOL = "+";
    private static final String INPUT_MINUS_SYMBOL = "-";
    private static final String INPUT_X_SYMBOL = "x";
    private static final String INPUT_MULTIPLY_SYMBOL = "*";
    private static final String INPUT_SLASH_SYMBOL = "/";

    public static void main(String[] args) {

        validateLength(args);

        double one = parseDoubleSafely(args[0]);
        String symbol = parseSymbol(args[1]);
        double two = parseDoubleSafely(args[2]);

        doCalculationSafely(one, symbol, two);
    }

    static void doCalculationSafely(double one, String symbol, double two) {
        try {
            out.println(format("%f %s %f = %f", one, symbol, two, doCalculation(one, symbol, two)));
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(format("Nie poprawny symbol! Proszę użyć %s, %s, %s lub %s",
                    INPUT_PLUS_SYMBOL, INPUT_MINUS_SYMBOL, INPUT_X_SYMBOL, INPUT_SLASH_SYMBOL));
        }
    }

    static String parseSymbol(String symbol) {
        switch (symbol) {
            case INPUT_X_SYMBOL:
            case INPUT_MULTIPLY_SYMBOL:
                return MULTIPLY;
            case INPUT_PLUS_SYMBOL:
                return PLUS;
            case INPUT_MINUS_SYMBOL:
                return MINUS;
            case INPUT_SLASH_SYMBOL:
                return DIVIDE;
            default:
                return symbol;
        }
    }

    static void validateLength(String[] args) {
        if (args.length < 3) {
            throw new IllegalStateException("Podałeś za mało argumentów. Potrzebne są 3 argumenty: liczba, znak działania i druga liczba.");
        }
    }

    static double parseDoubleSafely(String arg) {
        try {
            return parseDouble(arg);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(format("Podałeś argument \"%s\", który nie jest liczbą!", arg));
        }
    }
}
