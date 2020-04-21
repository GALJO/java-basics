package com.janek.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.basic.Counting.*;
import static org.junit.jupiter.api.Assertions.*;

class CountingTest {
    @Test
    @DisplayName("getSumUp - when input is 5 should return sum of numbers to 5")
    void getSumUpToPositive() {
        // given
        long input = 5;

        // when
        var result = getSumUpTo(input);

        // then
        assertEquals(15, result);
    }

    @Test
    @DisplayName("getSumUpE - when input is 5 should return sum of even numbers to 5")
    void getSumUpTo_E_Positive() {
        // given
        long input = 5;

        // when
        var result = getSumUpToEven(input);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("getSumUpNE - when input is 5 should return sum of not even numbers to 5")
    void getSumUpTO_NE_Positive() {
        // given
        long input = 5;

        // when
        var result = getSumUpToNotEven(input);

        // then
        assertEquals(9, result);
    }

    @Test
    @DisplayName("valid - when input correct should doesn't throw exception")
    void validatePositive() {
        // given
        var input = new String[]{"5"};

        // when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("valid - when input blank should throw IllegalStateException")
    void validateBlankNegative() {
        // given
        var input = new String[]{};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Nie podałeś argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("valid - when input isn't number should throw IllegalStateException")
    void validateNumberNegative() {
        // given
        var input = new String[]{"c"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Podałeś niepoprawny argument!", exception.getMessage());
    }
}