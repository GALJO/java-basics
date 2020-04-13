package com.janek.basic;

public class ByteLesson {

    static byte myByte;

    public static void main(String[] args) {
        printMyByte();
        
        addOneToMyByte();
        printMyByte();

        myByte = 127;
        printMyByte();

        // Add above max size
        addOneToMyByte();
        printMyByte();
    }

    private static void printMyByte() {
        System.out.println("My byte = " + myByte);
    }

    public static void addOneToMyByte() {
        myByte = (byte) (myByte + 1);
    }
}
