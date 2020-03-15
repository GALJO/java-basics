package com.janek.basics;

import static com.janek.basics.math.MathUtil.*;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;

public class CalcPremium {
    private static final String INPUT_PLUS_SYMBOL = "+";
    private static final String INPUT_PLUS_STRING = "dodać";
    private static final String INPUT_MINUS_SYMBOL = "-";
    private static final String INPUT_MINUS_STRING = "odjąć";
    private static final String INPUT_X_SYMBOL = "x";
    private static final String INPUT_X_STRING = "razy";
    private static final String INPUT_SLASH_SYMBOL = "/";
    private static final String INPUT_SLASH_STRING = "podzielić-przez";

    public static void main(String[] args) {

        validate(args);

        double one = parseDoubleSafely(args[0]);
        String symbol = parseSymbol(args[1]);
        double two = parseDoubleSafely(args[2]);

        doCalculationSafely(one, symbol, two);
    }

    private static void doCalculationSafely(double one, String symbol, double two) {
        try {
            out.println(format("%f %s %f = %f", one, symbol, two, doCalculation(one, symbol, two)));
        } catch (IllegalArgumentException e) {
            out.println(
                    format("Nie poprawny symbol! Proszę użyć \"%s\", \"%s\", \"%s\" lub \"%s\" (\"%s\", \"%s\", \"%s\" lub \"%s\").",
                            INPUT_PLUS_SYMBOL, INPUT_MINUS_SYMBOL, INPUT_X_SYMBOL, INPUT_SLASH_SYMBOL, INPUT_PLUS_STRING, INPUT_MINUS_STRING, INPUT_X_STRING, INPUT_SLASH_STRING)
            );
            exit(2);
        }
    }

    private static String parseSymbol(String symbol) {
        switch (symbol) {
            case INPUT_X_SYMBOL:
            case INPUT_X_STRING:
                return MULTIPLY;
            case INPUT_PLUS_SYMBOL:
            case INPUT_PLUS_STRING:
                return PLUS;
            case INPUT_MINUS_SYMBOL:
            case INPUT_MINUS_STRING:
                return MINUS;
            case INPUT_SLASH_STRING:
            case INPUT_SLASH_SYMBOL:
                return DIVIDE;
            default:
                return symbol;
        }
    }

    private static void validate(String[] args) {
        if (args.length < 3) {
            out.println(
                    format("Podałeś za mało argumentów. Potrzebne są 3 argumenty: liczba, znak działania " +
                            "(lub pisemną formę) i druga liczba.")
            );
            exit(1);
        }
    }

    private static double parseDoubleSafely(String arg) {
        try {
            return parseDouble(arg);
        } catch (NumberFormatException e) {
            out.println(format("Podałeś argument \"%s\", który nie jest liczbą!", arg));
            exit(2);
            throw e;
        }
    }
}
