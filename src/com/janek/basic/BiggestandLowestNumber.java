package com.janek.basic;

import static com.janek.lib.math.MathUtil.isDouble;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;

public class BiggestandLowestNumber {

    public static void main(String[] args) {
        validate(args);

        var result = getMinMaxNumber(args);

        out.print(format("Najmniejsza liczba z podanych to %f", result.min));
        out.print(format(", a największa to %f", result.max));

    }

    private static MinMaxResult getMinMaxNumber(String[] args) {
        double parsed0Args = parseDouble(args[0]);
        double minNumber = parsed0Args;
        double maxNumber = parsed0Args;
        for (int i = 1; i < args.length; i++) {
            double parsedIArgs = parseDouble(args[i]);
            if (minNumber > parsedIArgs) {
                minNumber = parsedIArgs;
            }

            if (maxNumber < parsedIArgs) {
                maxNumber = parsedIArgs;
            }
        }
        return new MinMaxResult(minNumber, maxNumber);
    }

    private static double getMinNumber(String[] args) {
        double minNumber = parseDouble(args[0]);
        for (int i = 1; i < args.length; i++) {
            if (minNumber > parseDouble(args[i])) {
                minNumber = parseDouble(args[i]);
            }
        }
        return minNumber;
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

    static class MinMaxResult {
        private final double min;
        private final double max;

        MinMaxResult(double min, double max) {
            this.min = min;
            this.max = max;
        }
    }
}




















// Na mnie nie zwracaj uwagi, ciiii
