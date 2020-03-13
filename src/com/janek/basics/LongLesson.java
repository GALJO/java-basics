package com.janek.basics;

public class LongLesson {

    static long myLong;

    public static void main(String[] args) {
        printMyLong();

        addOneToMyLong();
        printMyLong();

        myLong = Long.MAX_VALUE;
        printMyLong();

        // Add above max size
        addOneToMyLong();
        printMyLong();
    }

    private static void printMyLong() { System.out.println("My long = " + myLong); }

    public static void addOneToMyLong() { myLong = myLong + 1; }

}
