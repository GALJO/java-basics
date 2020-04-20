package com.janek.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.calculator.BasicCalc.*;
import static org.junit.jupiter.api.Assertions.*;

// TODO add names
class BasicCalcTest {
    @Test
    @DisplayName("test")
    void test1() {
        // given
        String input = "5";

        // when
        var result = parseDoubleSafely(input);

        // then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("test")
    void test2() {
        // given
        String input = "k";

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> parseDoubleSafely(input));
        assertEquals("Podałeś argument \"k\", który nie jest liczbą!", exception.getMessage());
    }

    @Test
    @DisplayName("test")
    void test3() {
        // given
        var input = new String[]{"5", "3"};

        // when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("test")
    void test4() {
        // given
        var input = new String[]{"1"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Podałeś za mało argumentów! Poproszę 2 argumenty.", exception.getMessage());
    }

}