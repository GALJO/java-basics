package com.janek.calculator;

import static com.janek.lib.math.MathUtil.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.System.out;

public class powerMath {
    public static void main(String[] args) {
        validate(args);

        double base = parseDouble(args[0]);
        int exponent = parseInt(args[1]);

        double result = power(base, exponent);

        out.println(format("Potęga o podstawie %f i wykładniku %d to %f", base, exponent, result));
    }

    public static void validate(String[] args) {
        valLength(args);
        valBase(args);
        valExponent(args);
    }

    private static void valLength(String[] args) {
        if (args.length <= 1) {
            throw new IllegalStateException("Podałeś za mało argumentów!");
        }
    }

    private static void valBase(String[] args) {
        if (!isDouble(args[0])) {
            throw new IllegalStateException(format("Błędna podstawa! (%s)", args[0]));
        }
    }

    private static void valExponent(String[] args) {
        if (!isInt(args[1])) {
            throw new IllegalStateException(format("Błędny wykładnik! (%s)", args[1]));
        }
    }

}
