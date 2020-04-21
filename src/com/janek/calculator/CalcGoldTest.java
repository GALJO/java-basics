package com.janek.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.calculator.CalcGold.*;
import static org.junit.jupiter.api.Assertions.*;

class CalcGoldTest {

    @Test
    @DisplayName("calcResult - should return result of operation in input (6)")
    void calculateResultPositive() {
        // given
        var input = new String[]{"10", "+", "5", "-", "6", "*", "2", "/", "3"};

        // when
        var result = calculateResult(input);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("valNumber - when even fields in input is number shouldn't throw exception")
    void validateNumberPositive() {
        // given
        var input = new String[]{"5", "+", "2"};

        // when and then
        assertDoesNotThrow(() -> validateNumber(input));
    }

    @Test
    @DisplayName("valNumber - when even fields in input isn't number should throw IllegalStateException")
    void validateNumberNegative() {
        // given
        var input = new String[]{"o", "+", "2"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateNumber(input));
        assertEquals("Podałeś nieprawidłową liczbę! (o)", exception.getMessage());
    }

    @Test
    @DisplayName("valNumber - when even fields in input isn't number should throw IllegalStateException")
    void validateNumberNegative2() {
        // given
        var input = new String[]{"5", "+", "r"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateNumber(input));
        assertEquals("Podałeś nieprawidłową liczbę! (r)", exception.getMessage());
    }

    @Test
    @DisplayName("valSymbol - when not even fields in input is math symbol shouldn't throw exception")
    void validateSymbolPositive() {
        // given
        var input = new String[]{"5", "+", "5", "-", "8", "*", "5", "/", "2"};

        // when and then
        assertDoesNotThrow(() -> validateSymbol(input));
    }

    @Test
    @DisplayName("valSymbol - when not even field in input isn't math symbol should throw IllegalStateException")
    void validateSymbolNegative() {
        // given
        var input = new String[]{"5", "*", "8", "x", "2", "^", "6"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateSymbol(input));
        assertEquals("Podałeś niepoprawny symbol! (^)", exception.getMessage());

    }

    @Test
    @DisplayName("valArgs - when input.length is not even and input.length >= 3 shouldn't throw exception")
    void validateArgsPositive() {
        // given
        var input = new String[]{"5", "+", "5", "-", "5", "*", "5", "/", "5"};

        // when and then
        assertDoesNotThrow(() -> validateArgsNumber(input));
    }

    @Test
    @DisplayName("valArgs - when input.length < 3 should throw IllegalStateException")
    void validateArgsLengthNegative() {
        // given
        var input = new String[]{"5", "+"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateArgsNumber(input));
        assertEquals("Podałeś za mało argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("valArgs - when input.length is even should throw IllegalStateException")
    void validateArgsEvenNegative() {
        // given
        var input = new String[]{"5", "+", "8", "-"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateArgsNumber(input));
        assertEquals("Podałeś nieprawidłową liczbę argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("parseSymbol - when input is + should return +")
    void parseSymbolPositive1() {
        // given
        String input = "+";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("+", result);
    }

    @Test
    @DisplayName("parseSymbol - when input is - should return -")
    void parseSymbolPositive2() {
        // given
        String input = "-";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("-", result);
    }

    @Test
    @DisplayName("parseSymbol - when input is x should return *")
    void parseSymbolPositive3() {
        // given
        String input = "x";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("*", result);
    }

    @Test
    @DisplayName("parseSymbol - when input is / should return /")
    void parseSymbolPositive4() {
        // given
        String input = "/";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("/", result);
    }

    @Test
    @DisplayName("parseSymbol - when input is other should return input")
    void parseSymbolNegative() {
        // given
        String input = "k";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("k", result);
    }
}