package com.janek.calculator;

import static com.janek.lib.math.MathUtil.*;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.out;

public class CalcGold {

    private static final String INPUT_PLUS_SYMBOL = "+";
    private static final String INPUT_MINUS_SYMBOL = "-";
    private static final String INPUT_X_SYMBOL = "x";
    private static final String INPUT_MULTIPLY_SYMBOL = "*";
    private static final String INPUT_SLASH_SYMBOL = "/";

    public static void main(String[] args) {
        validateArgsNumber(args);
        validateSymbol(args);
        validateNumber(args);

        var result = calculateResult(args);
        printResult(args, result);
    }

    private static void printResult(String[] args, double result) {
        for (String arg : args) {
            out.print(format("%s ", arg));
        }
        out.println(format("= %f", result));
    }

    static double calculateResult(String[] args) {
        double result = doCalculation(parseDouble(args[0]), parseSymbol(args[1]), parseDouble(args[2]));

        for (int i = 3; i < args.length; i += 2) {
            result = doCalculation(result, parseSymbol(args[i]), parseDouble(args[i + 1]));
        }
        return result;
    }

    static void validateNumber(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            String number = args[i];
            if (!isDouble(number)) {
                throw new IllegalStateException(format("Podałeś nieprawidłową liczbę! (%s)", number));
            }
        }
    }

    static void validateSymbol(String[] args) {
        for (int i = 1; i < args.length; i += 2) {
            String symbol = args[i];
            if (!(symbol.equals(INPUT_PLUS_SYMBOL) || symbol.equals(INPUT_MINUS_SYMBOL) || symbol.equals(INPUT_X_SYMBOL) ||
                    symbol.equals(INPUT_SLASH_SYMBOL) || symbol.equals(INPUT_MULTIPLY_SYMBOL))) {

                throw new IllegalStateException(format("Podałeś niepoprawny symbol! (%s)", symbol));
            }
        }
    }

    static void validateArgsNumber(String[] args) {
        if (args.length < 3) {
            throw new IllegalStateException("Podałeś za mało argumentów!");
        }

        if (isEven(args.length)) {
            throw new IllegalStateException("Podałeś nieprawidłową liczbę argumentów!");
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
}