package com.janek.basics;

import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.*;
import static com.janek.basics.math.MathUtil.*;

public class CalcPremium {
    public static final String PLUS_SYMBOL = "+";
    public static final String PLUS_STRING = "dodać";
    public static final String MINUS_SYMBOL = "-";
    public static final String MINUS_STRING = "odjąć";
    public static final String X_SYMBOL = "x";
    public static final String X_STRING = "razy";
    public static final String SLASH_SYMBOL = "/";
    public static final String SLASH_STRING = "podzielić-przez";

    public static void main(String[] args) {

        validate(args);

        double one = parseDoubleSafely(args[0]);
        String symbol = args[1];
        double two = parseDoubleSafely(args[2]);

        checkAddition(symbol, one, two);
        checkSubtraction(symbol, one, two);
        checkMultiplication(symbol, one, two);
        checkDivision(symbol, one, two);
        checkPropriety(symbol);
    }

    private static void checkPropriety(String symbol) {
        if (!symbol.equals(PLUS_SYMBOL) && !symbol.equals(MINUS_SYMBOL) && !symbol.equals(X_SYMBOL) && !symbol.equals(SLASH_SYMBOL) && !symbol.equals(PLUS_STRING) && !symbol.equals(MINUS_STRING) && !symbol.equals(X_STRING) && !symbol.equals(SLASH_STRING)) {
            out.println(format("Nie poprawny symbol! Proszę użyć \"%s\", \"%s\", \"%s\" lub \"%s\" (\"%s\", \"%s\", \"%s\" lub \"%s\").", PLUS_SYMBOL, MINUS_SYMBOL, X_SYMBOL, SLASH_SYMBOL, PLUS_STRING, MINUS_STRING, X_STRING, SLASH_STRING));
            exit(2);
        }
    }

    private static void checkDivision(String symbol, double one, double two) {
        if (symbol.equals(SLASH_SYMBOL) || symbol.equals(SLASH_STRING)) {
            out.println(divideNumbers(one, two));
            exit(0);
        }
    }


    private static void checkMultiplication(String symbol, double one, double two) {
        if (symbol.equals(X_SYMBOL) || symbol.equals(X_STRING)) {
            out.println(multiplyNumbers(one, two));
            exit(0);
        }
    }

    private static void checkSubtraction(String symbol, double one, double two) {
        if (symbol.equals(MINUS_SYMBOL) || symbol.equals(MINUS_STRING)) {
            out.println(subtractNumbers(one, two));
            exit(0);
        }
    }

    private static void checkAddition(String symbol, double one, double two) {
        if (symbol.equals(PLUS_SYMBOL) || symbol.equals(PLUS_STRING)) {
            out.println(addNumbers(one, two));
            exit(0);
        }
    }

    private static void validate(String[] args) {
        if (args.length < 3) {
            out.println(format("Podałeś za mało argumentów. Potrzebne są 3 argumenty: liczba, znak działania (lub pisemną formę) i druga liczba."));
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
