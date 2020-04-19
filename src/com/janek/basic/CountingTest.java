package com.janek.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.basic.Counting.*;
import static org.junit.jupiter.api.Assertions.*;

//TODO make names
class CountingTest {
    @Test
    @DisplayName("test1")
    void test1() {
        // given
        long input = 5;

        // when
        var result = getSumUpTo(input);

        // then
        assertEquals(15, result);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        long input = 5;

        // when
        var result = getSumUpToEven(input);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        long input = 5;

        // when
        var result = getSumUpToNotEven(input);

        // then
        assertEquals(9, result);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        var input = new String[]{"5"};

        // when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("test5")
    void test5() {
        // given
        var input = new String[]{};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Nie podałeś argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("test6")
    void test6() {
        // given
        var input = new String[]{"c"};

        // when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Podałeś niepoprawny argument!", exception.getMessage());
    }
}