package com.janek.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.basic.BiggestNumber.*;
import static org.junit.jupiter.api.Assertions.*;

class BiggestNumberTest {

    @Test
    @DisplayName("should return biggest number from input (80)")
    void maxNumberPositive() {
        //given
        var input = new String[]{"55", "80", "10", "5", "-8", "15.5"};

        //when
        var result = getMaxNumber(input);

        //then
        assertEquals(80, result);
    }

    @Test
    @DisplayName("when input isn't number should return NumberFormatException")
    void maxNumberNegative() {
        //given
        var input = new String[]{"80", "10", "5", "c"};

        //when and then
        assertThrows(NumberFormatException.class, () -> getMaxNumber(input));
    }

    @Test
    @DisplayName("should doesn't throw exception")
    void validatePositive() {
        //given
        var input = new String[]{"80", "80", "4", "6.4"};

        //when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("when input blank should return IllegalStateException")
    void validateBlankNegative() {
        //given
        var input = new String[]{};

        //when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Nie podałeś argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("when input isn't number should return IllegalStateException")
    void validateNumberNegative() {
        //given
        var input = new String[]{"8", "-4", "a", "7"};

        //when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Niepoprawny element! (a)", exception.getMessage());
    }
}