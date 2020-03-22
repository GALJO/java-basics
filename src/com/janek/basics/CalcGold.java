package com.janek.basics;

import static com.janek.basics.math.MathUtil.*;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;

public class CalcGold {

    private static final String INPUT_PLUS_SYMBOL = "+";
    private static final String INPUT_PLUS_STRING = "dodać";
    private static final String INPUT_MINUS_SYMBOL = "-";
    private static final String INPUT_MINUS_STRING = "odjąć";
    private static final String INPUT_X_SYMBOL = "x";
    private static final String INPUT_X_STRING = "razy";
    private static final String INPUT_SLASH_SYMBOL = "/";
    private static final String INPUT_SLASH_STRING = "podzielić-przez";

    public static final int VALIDATION_EXIT_CODE = 1;

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

    private static double calculateResult(String[] args) {
        double result = doCalculation(parseDouble(args[0]), parseSymbol(args[1]), parseDouble(args[2]));

        for (int i = 3; i < args.length; i += 2) {
            result = doCalculation(result, parseSymbol(args[i]), parseDouble(args[i + 1]));
        }
        return result;
    }

    private static void validateNumber(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            String number = args[i];
            if (!isNumber(number)) {
                out.println(format("Podałeś nieprawidłową liczbę! (%s)", number));
                exit(VALIDATION_EXIT_CODE);
            }
        }
    }

    private static void validateSymbol(String[] args) {
        for (int i = 1; i < args.length; i += 2) {
            String symbol = args[i];
            if (!(symbol.equals(INPUT_PLUS_SYMBOL) || symbol.equals(INPUT_MINUS_SYMBOL)  || symbol.equals(INPUT_X_SYMBOL) ||
                    symbol.equals(INPUT_SLASH_SYMBOL) || symbol.equals(INPUT_PLUS_STRING) || symbol.equals(INPUT_MINUS_STRING) ||
                    symbol.equals(INPUT_X_STRING) || symbol.equals(INPUT_SLASH_STRING))) {

                out.println(format("Podałeś niepoprawny symbol! (%s)", symbol));
                exit(VALIDATION_EXIT_CODE);
            }
        }
    }

    private static void validateArgsNumber(String[] args) {
        if (args.length < 3) {
            out.println("Podałeś za mało argumentów!");
            exit(VALIDATION_EXIT_CODE);
        }

        if (isEven(args.length)) {
            out.println("Podałeś nieprawidłową liczbę argumentów!");
            exit(VALIDATION_EXIT_CODE);
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
 }