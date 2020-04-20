package com.janek.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.calculator.CalcGold.*;
import static org.junit.jupiter.api.Assertions.*;

// TODO add names
class CalcGoldTest {

    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var input = new String[]{"10", "+", "5", "-", "6", "*", "2", "/", "3"};

        // when
        var result = calculateResult(input);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var input = new String[]{"5", "+", "2"};

        // when and then
        assertDoesNotThrow(() -> validateNumber(input));
    }

    @Test
    @DisplayName("test2")
    void test3() {
        // given
        var input = new String[]{"o", "+", "2"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateNumber(input));
        assertEquals("Podałeś nieprawidłową liczbę! (o)", exception.getMessage());
    }

    @Test
    @DisplayName("test2")
    void test4() {
        // given
        var input = new String[]{"5", "+", "r"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateNumber(input));
        assertEquals("Podałeś nieprawidłową liczbę! (r)", exception.getMessage());
    }

    @Test
    @DisplayName("test3")
    void test5() {
        // given
        var input = new String[]{"5", "+", "5", "-", "8", "*", "5", "/", "2"};

        // when and then
        assertDoesNotThrow(() -> validateSymbol(input));
    }

    @Test
    @DisplayName("test3")
    void test6() {
        // given
        var input = new String[]{"5", "*", "8", "x", "2", "^", "6"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateSymbol(input));
        assertEquals("Podałeś niepoprawny symbol! (^)", exception.getMessage());

    }

    @Test
    @DisplayName("test4")
    void test7() {
        // given
        var input = new String[]{"5", "+", "5", "-", "5", "*", "5", "/", "5"};

        // when and then
        assertDoesNotThrow(() -> validateArgsNumber(input));
    }

    @Test
    @DisplayName("test4")
    void test8() {
        // given
        var input = new String[]{"5", "+"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateArgsNumber(input));
        assertEquals("Podałeś za mało argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("test4")
    void test9() {
        // given
        var input = new String[]{"5", "+", "8", "-"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validateArgsNumber(input));
        assertEquals("Podałeś nieprawidłową liczbę argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("test5")
    void test10() {
        // given
        String input = "+";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("+", result);
    }

    @Test
    @DisplayName("test5")
    void test11() {
        // given
        String input = "-";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("-", result);
    }

    @Test
    @DisplayName("test5")
    void test12() {
        // given
        String input = "x";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("*", result);
    }

    @Test
    @DisplayName("test5")
    void test13() {
        // given
        String input = "/";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("/", result);
    }

    @Test
    @DisplayName("test5")
    void test14() {
        // given
        String input = "k";

        // when
        var result = parseSymbol(input);

        // then
        assertEquals("k", result);
    }
}