package com.janek.basics;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.System.*;

public class Counting {
    public static void main(String[] args) {
        validate(args.length);

        int countNumber = parseIntSafely(args[0]);

        out.print(format("%d --- ", countNumber));
        for (int i = 0; !(i == countNumber); i++) {
            out.print(format("%d, ", i));
        }
        out.print(format("%d.", countNumber));
    }

    private static int parseIntSafely(String arg) {
        try {
            return parseInt(arg);
        } catch (NumberFormatException e) {
            out.println("Podałeś niepoprawny argument!");
            exit(1);
            throw e;
        }
    }

    private static void validate(int amountOfArgs) {
        if (amountOfArgs == 0) {
            out.println("Nie podałeś argumentów!");
            exit(2);
        }
    }
}
