package com.janek.basics;

import static java.lang.String.format;
import static java.lang.System.*;

public class Counting {
    public static void main(String[] args) {
        validate(args.length);

        long countNumber = parseLongSafely(args[0]);
        long sum = 0;
        for (long i = 1; i <= countNumber; i++) {
            sum += i;
        }
        out.print(format("= %d", sum));
    }

    private static long parseLongSafely(String arg) {
        try {
            return Long.parseLong(arg);
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
