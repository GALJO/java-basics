package com.janek.basic;

import static com.janek.lib.math.MathUtil.isDouble;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;

public class BiggestNumber {

    public static void main(String[] args) {
        validate(args);

        double maxNumber = getMaxNumber(args);
        out.println(format("Największa liczba z podanych to: %f", maxNumber));
    }

    private static double getMaxNumber(String[] args) {
        double maxNumber = parseDouble(args[0]);
        for (int i = 1; i < args.length; i++) {
            if (maxNumber < parseDouble(args[i])) {
                maxNumber = parseDouble(args[i]);
            }
        }
        return maxNumber;
    }

    private static void validate(String[] args) {
        validateNotEmpty(args);
        validateOnlyNumbers(args);
    }

    private static void validateNotEmpty(String[] args) {
        if (args.length == 0) {
            out.println("Nie podałeś argumentów!");
            exit(2);
        }
    }

    private static void validateOnlyNumbers(String[] args) {
        for (String element : args) {
            if (!isDouble(element)) {
                out.println(format("Niepoprawny element! (%s)", element));
                exit(1);
            }
        }
    }
}
