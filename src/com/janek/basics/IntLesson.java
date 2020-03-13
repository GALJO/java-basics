package com.janek.basics;

public class IntLesson {

    static int myInt;

    public static void main(String[] args) {
        printMyInt();

        addOneToMyInt();
        printMyInt();

        myInt = 2_147_483_647;
        printMyInt();

        // Add above max size
        addOneToMyInt();
        printMyInt();
    }

    private static void printMyInt() {
        System.out.println("My int = " + myInt);
    }

    public static void addOneToMyInt() { myInt = myInt + 1; }
}
