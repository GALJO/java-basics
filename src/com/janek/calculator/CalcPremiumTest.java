package com.janek.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.calculator.CalcPremium.*;
import static org.junit.jupiter.api.Assertions.*;

class CalcPremiumTest {
    @Test
    @DisplayName("doCalcSafe - shouldn't throw exception")
    void doCalcPositive() {
        // given
        double one = 10;
        String symbol = "+";
        double two = 5;

        // when and then
        assertDoesNotThrow(() -> doCalculationSafely(one, symbol, two));
    }

    @Test
    @DisplayName("doCalcSafe - shouldn't throw exception")
    void doCalcPositive2() {
        // given
        double one = 10;
        String symbol = "-";
        double two = 5;

        // when and then
        assertDoesNotThrow(() -> doCalculationSafely(one, symbol, two));
    }

    @Test
    @DisplayName("doCalcSafe - shouldn't throw exception")
    void doCalcPositive3() {
        // given
        double one = 10;
        String symbol = "*";
        double two = 5;

        // when and then
        assertDoesNotThrow(() -> doCalculationSafely(one, symbol, two));
    }

    @Test
    @DisplayName("doCalcSafe - shouldn't throw exception")
    void doCalcPositive4() {
        // given
        double one = 10;
        String symbol = "/";
        double two = 5;

        // when and then
        assertDoesNotThrow(() -> doCalculationSafely(one, symbol, two));
    }

    @Test
    @DisplayName("doCalcSafe - should throw IllegalStateException")
    void doCalcNegative() {
        // given
        double one = 10;
        String symbol = "r";
        double two = 5;

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> doCalculationSafely(one, symbol, two));
        assertEquals("Nie poprawny symbol! Proszę użyć +, -, x lub /", exception.getMessage());
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

    @Test
    @DisplayName("valLength - when input.length >= 3 shouldn't throw exception")
    void valLengthPositive() {
        //given
        var input = new String[]{"5", "+", "5"};

        // when and then
        assertDoesNotThrow(() -> validateLength(input));
    }

    @Test
    @DisplayName("valLength - when input.length < 3 should throw IllegalStateException")
    void valLengthNegative() {
        //given
        var input = new String[]{"5", "+"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateLength(input));
        assertEquals("Podałeś za mało argumentów. Potrzebne są 3 argumenty: liczba, znak działania i druga liczba.", exception.getMessage());
    }

    @Test
    @DisplayName("parseDouble - when input is number shouldn't throw exception")
    void parseDoublePositive() {
        //given
        String input = "5";

        // when and then
        assertDoesNotThrow(() -> parseDoubleSafely(input));
    }

    @Test
    @DisplayName("parseDouble - when input isn't number should throw exception")
    void parseDoubleNegative() {
        //given
        String input = "o";

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> parseDoubleSafely(input));
        assertEquals("Podałeś argument \"o\", który nie jest liczbą!", exception.getMessage());
    }
}