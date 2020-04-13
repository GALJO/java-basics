package com.janek.basics;

import static com.janek.basics.math.MathUtil.isLong;
import static java.lang.Long.parseLong;
import static java.lang.String.format;
import static java.lang.System.*;

public class Counting {
    public static void main(String[] args) {
        validate(args);

        long countNumber = parseLong(args[0]);
        out.println(format("Suma liczb całkowitych od 1 do %d = %d", countNumber, getSumUpTo(countNumber)));
        out.println(format("Suma liczb parzystych (takich co mają pary) od 1 do %d = %d", countNumber, getSumUpToEven(countNumber)));
        out.println(format("Suma liczb nieparzystych (takich co nie mają pary) od 1 do %d = %d", countNumber, getSumUpToNotEven(countNumber)));
    }

    private static void validate(String[] args) {
        if (args.length == 0) {
            out.println("Nie podałeś argumentów!");
            exit(2);
        }

        if (!isLong(args[0])) {
            out.println("Podałeś niepoprawny argument!");
            exit(1);
        }
    }

    private static long getSumUpTo(long ceilNumber) {
        long sum = 0;
        for (long i = 1; i <= ceilNumber; i++) {
            sum += i;
        }
        return sum;
    }

    private static long getSumUpToEven(long ceilNumber) {
        long sum = 0;
        for (long i = 2; i <= ceilNumber; i += 2) {
            sum += i;
        }
        return sum;
    }

    private static long getSumUpToNotEven(long ceilNumber) {
        long sum = 0;
        for (long i = 1; i <= ceilNumber; i += 2) {
            sum += i;
        }
        return sum;
    }
}

