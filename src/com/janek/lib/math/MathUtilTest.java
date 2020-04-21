package com.janek.lib.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.lib.math.MathUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {
    @Test
    @DisplayName("addNumbers - should return one + two")
    void addNumbersTest() {
        // given
        double one = 5;
        double two = 3;

        // when
        var result = addNumbers(one, two);

        // then
        assertEquals(8, result);
    }

    @Test
    @DisplayName("subNumbers - should return one - two")
    void subtractNumbersTest() {
        // given
        double one = 5;
        double two = 3;

        // when
        var result = subtractNumbers(one, two);

        // then
        assertEquals(2, result);
    }

    @Test
    @DisplayName("multiNumbers - should return one * two")
    void multiplyNumbersTest() {
        // given
        double one = 5;
        double two = 3;

        // when
        var result = multiplyNumbers(one, two);

        // then
        assertEquals(15, result);
    }

    @Test
    @DisplayName("divNumbers - should return one / two")
    void divideNumbersTest() {
        // given
        double one = 6;
        double two = 3;

        // when
        var result = divideNumbers(one, two);

        // then
        assertEquals(2, result);
    }

    @Test
    @DisplayName("doCalc - should return one + two (doCalculation)")
    void doCalculationPlusTest() {
        //given
        double one = 8;
        String symbol = "+";
        double two = 4;

        // when
        var result = doCalculation(one, symbol, two);

        // then
        assertEquals(12, result);
    }

    @Test
    @DisplayName("doCalc - should return one - two (doCalculation)")
    void doCalculationMinusTest() {
        //given
        double one = 8;
        String symbol = "-";
        double two = 5;

        // when
        var result = doCalculation(one, symbol, two);

        // then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("doCalc - should return one * two (doCalculation)")
    void doCalculationMultiplyTest() {
        //given
        double one = 8;
        String symbol = "*";
        double two = 4;

        // when
        var result = doCalculation(one, symbol, two);

        // then
        assertEquals(32, result);
    }

    @Test
    @DisplayName("doCalc - should return one / two (doCalculation)")
    void doCalculationDivideTest() {
        //given
        double one = 8;
        String symbol = "/";
        double two = 4;

        // when
        var result = doCalculation(one, symbol, two);

        // then
        assertEquals(2, result);
    }

    @Test
    @DisplayName("doCalc - when symbol isn't correct should throw IllegalArgumentException")
    void doCalculationNegative() {
        // given
        double one = 8;
        String symbol = "t";
        double two = 4;

        // when and then
        var exception = assertThrows(IllegalArgumentException.class, () -> doCalculation(one, symbol, two));
        assertEquals("Unsupported symbol", exception.getMessage());
    }

    @Test
    @DisplayName("isEven - when number is even should return true")
    void isEvenPositive() {
        // given
        int number = 2;

        // when
        var result = isEven(number);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("isEven - when number isn't even should return false")
    void isEvenNegative() {
        // given
        int number = 3;

        // when
        var result = isEven(number);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("isDouble - when text can be double should return true")
    void isDoublePositive() {
        // given
        String text = "5";

        // when
        var result = isDouble(text);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("isDouble - when text can't be double should return false")
    void isDoubleNegative() {
        // given
        String text = "o";

        // when
        var result = isDouble(text);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("isLong - when text can be long should return true")
    void isLongPositive() {
        // given
        String text = "8";

        // when
        var result = isLong(text);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("isLong - when text can't be double should return false")
    void isLongNegative() {
        // given
        String text = "g";

        // when
        var result = isLong(text);

        // then
        assertFalse(result);
    }
}