package com.janek.basics;

import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.*;
import static com.janek.basics.math.MathUtil.*;

public class CalcPremium {
    private static final String PLUS_SYMBOL = "+";
    private static final String PLUS_STRING = "dodać";
    private static final String MINUS_SYMBOL = "-";
    private static final String MINUS_STRING = "odjąć";
    private static final String X_SYMBOL = "x";
    private static final String X_STRING = "razy";
    private static final String SLASH_SYMBOL = "/";
    private static final String SLASH_STRING = "podzielić-przez";

    public static void main(String[] args) {

        validate(args);

        double one = parseDoubleSafely(args[0]);
        String symbol = parseSymbol(args[1]);
        double two = parseDoubleSafely(args[2]);

        try {
            double result = doCalculation(one, symbol, two);
            out.println(format("%f %s %f = %f", one, symbol, two, result));
        } catch (IllegalArgumentException e) {
            out.println(format("Nie poprawny symbol! Proszę użyć \"%s\", \"%s\", \"%s\" lub \"%s\" (\"%s\", \"%s\", \"%s\" lub \"%s\").", PLUS_SYMBOL, MINUS_SYMBOL, X_SYMBOL, SLASH_SYMBOL, PLUS_STRING, MINUS_STRING, X_STRING, SLASH_STRING));
            exit(2);
        }
    }

    private static String parseSymbol(String symbol) {
        switch (symbol) {
            case X_SYMBOL:
            case X_STRING:
                return "*";
            case PLUS_STRING:
                return "+";
            case MINUS_STRING:
                return "-";
            case SLASH_STRING:
                return "/";
            default:
                return symbol;
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
