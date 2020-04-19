package com.janek.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.janek.basic.BiggestNumber.*;
import static org.junit.jupiter.api.Assertions.*;

//TODO make names
class BiggestNumberTest {

    @Test
    @DisplayName("test1")
    void test1() {
        //given
        var input = new String[]{"55", "80", "10", "5", "-8", "15.5"};

        //when
        var result = getMaxNumber(input);

        //then
        assertEquals(80, result);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        //given
        var input = new String[]{"80", "10", "5", "c"};

        //when and then
        assertThrows(NumberFormatException.class, () -> getMaxNumber(input));
    }

    @Test
    @DisplayName("test3")
    void test3() {
        //given
        var input = new String[]{"80", "80", "4", "6.4"};

        //when and then
        assertDoesNotThrow(() -> validate(input));
    }

    @Test
    @DisplayName("test4")
    void test4() {
        //given
        var input = new String[]{};

        //when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Nie podałeś argumentów!", exception.getMessage());
    }

    @Test
    @DisplayName("test5")
    void test5() {
        //given
        var input = new String[]{"8", "-4", "a", "7"};

        //when and then
        var exception = assertThrows(IllegalStateException.class, () -> validate(input));
        assertEquals("Niepoprawny element! (a)", exception.getMessage());
    }
}