package com.janek.basics;

import static com.janek.basics.math.MathUtil.*;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;

public class BasicCalc {

    public static void main(String[] args) {

        // Validate input parameters
        validate(args);

        // Parse arguments
        double one = parseDoubleSafely(args[0]);
        double two = parseDoubleSafely(args[1]);

        // Displaying results
        out.println(format("Podałeś liczby %f i %f%n", one, two));
        out.println(format("Suma tych liczb to: %f", addNumbers(one, two)));
        out.println(format("Różnica tych liczb to: %f", subtractNumbers(one, two)));
        out.println(format("Iloczyn tych liczb to: %f", multiplyNumbers(one, two)));
        out.println(format("Iloraz tych liczb to: %f", divideNumbers(one, two)));
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

    private static void validate(String[] args) {
        if (args.length < 2) {
            out.println("Podałeś za mało argumentów! Poproszę 2 argumenty.");
            exit(1);
        }
    }


}
