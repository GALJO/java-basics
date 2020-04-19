package com.janek.basic;

import static com.janek.lib.math.MathUtil.isDouble;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.out;

public class BiggestAndLowestNumber {

    public static void main(String[] args) {
        validate(args);

        var result = getMinMaxNumber(args);

        out.println(format("Najmniejsza liczba z podanych to %f, a największa to %f", result.min, result.max));
    }

    static MinMaxResult getMinMaxNumber(String[] args) {
        double minNumber = parseDouble(args[0]);
        double maxNumber = minNumber;
        for (int i = 1; i < args.length; i++) {
            double number = parseDouble(args[i]);
            if (minNumber > number) {
                minNumber = number;
            }

            if (maxNumber < number) {
                maxNumber = number;
            }
        }
        return new MinMaxResult(minNumber, maxNumber);
    }

    static void validate(String[] args) {
        validateNotEmpty(args);
        validateOnlyNumbers(args);
    }

    private static void validateNotEmpty(String[] args) {
        if (args.length == 0) {
            throw new IllegalStateException("Nie podałeś argumentów!");
        }
    }

    private static void validateOnlyNumbers(String[] args) {
        for (String element : args) {
            if (!isDouble(element)) {
                throw new IllegalStateException(format("Niepoprawny element! (%s)", element));
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

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }
    }
}