package com.janek.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.calculator.BasicCalc.*;
import static org.junit.jupiter.api.Assertions.*;

class BasicCalcTest {
    @Test
    @DisplayName("when input is correct should return double")
    void parseDoublePositive() {
        // given
        String input = "5";

        // when
        var result = parseDoubleSafely(input);

        // then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("when input is incorrect should throw IllegalStateException")
    void parseDoubleNegative() {
        // given
        String input = "k";

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> parseDoubleSafely(input));
        assertEquals("Podałeś argument \"k\", który nie jest liczbą!", exception.getMessage());
    }

    @Test
    @DisplayName("when input is correct should doesn't throw anything")
    void validatePositive() {
        // given
        var input = new String[]{"5", "3"};

        // when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("when input is incorrect should throw IllegalStateException")
    void validateNegative() {
        // given
        var input = new String[]{"1"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Podałeś za mało argumentów! Poproszę 2 argumenty.", exception.getMessage());
    }

}