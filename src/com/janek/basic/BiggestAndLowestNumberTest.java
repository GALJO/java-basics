package com.janek.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.basic.BiggestAndLowestNumber.*;
import static org.junit.jupiter.api.Assertions.*;

class BiggestAndLowestNumberTest {

    @Test
    @DisplayName("getMinMax - should return correct min and max number")
    void getMinMaxNumberCorrect() {
        //given
        var input = new String[]{"55", "80", "10", "5", "-8", "15.5"};

        //when
        var result = getMinMaxNumber(input);

        //then
        assertEquals(-8, result.getMin());
        assertEquals(80, result.getMax());
    }

    @Test
    @DisplayName("getMinMax - when input string isn't number should throw exception")
    void getMinMaxNumberNegative() {
        //given
        var input = new String[]{"80", "10", "5", "c"};

        //when and then
        assertThrows(NumberFormatException.class, () -> getMinMaxNumber(input));

    }

    @Test
    @DisplayName("validate - shouldn't trow exception")
    void validatePositive() {
        //given
        var input = new String[]{"80", "80", "4", "6.4"};

        //when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("validate - when input is blank should trow IllegalStateException")
    void validateBlankNegative() {
        //given
        var input = new String[]{};

        //when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Nie podałeś argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("validate - when can't parse input should trow IllegalStateException")
    void validateParseNegative() {
        //given
        var input = new String[]{"8", "-4", "a", "7"};

        //when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Niepoprawny element! (a)", exception.getMessage());
    }

}