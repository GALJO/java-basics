package com.janek.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.calculator.powerMath.*;
import static org.junit.jupiter.api.Assertions.*;

class powerMathTest {

    @Test
    @DisplayName("when input is correct shouldn't throw exception")
    void validatePositive() {
        // given
        var input = new String[]{"5", "3"};

        // when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("when input is too short should throw IllegalStateException")
    void validateLengthNegative() {
        // given
        var input = new String[]{"8"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Podałeś za mało argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("when input[0] is incorrect should throw IllegalStateException")
    void validateBaseNegative() {
        // given
        var input = new String[]{"c", "5"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Błędna podstawa! (c)", exception.getMessage());
    }

    @Test
    @DisplayName("when input[1] is incorrect should throw IllegalStateException")
    void validateExponentNegative() {
        // given
        var input = new String[]{"8", "d"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Błędny wykładnik! (d)", exception.getMessage());
    }

}