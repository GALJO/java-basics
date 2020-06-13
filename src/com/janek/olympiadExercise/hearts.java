package com.janek.olympiadExercise;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

public class hearts {
    public static void main(String[] args) {
        int N = parseInt(args[0]);

        for (int i = 0; i < N; i++) {
            printHeart();
        }
    }

    public static void printHeart() {
        out.println("@@@    @@@");
        out.println("@  @  @   @");
        out.println("@    @    @");
        out.println("@         @");
        out.println(" @       @");
        out.println("  @     @");
        out.println("   @   @");
        out.println("    @ @");
        out.println("     @");
    }
}
