package com.janek.olympiadExercise;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

public class hurra {
    public static void main(String[] args) {
        int N = parseInt(args[0]);

        for(int i = 0; i <= N; i++) {
            if(i % 7 == 0) {
                out.println("Hurra!");
            } else if(i % 11 == 0) {
                out.println("Super!");
            } else if (i % 7 == 0 && N % 11 == 0) {
                out.println("Wiwat!");
            } else { out.println(i); }
        }
    }
}
