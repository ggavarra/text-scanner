package com.dtp.digitalscanner.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberInterpreterTest {

    NumberInterpreter numberInterpreter;

    @BeforeEach
    void setUp() {
        numberInterpreter = new NumberInterpreter();
    }

    @Test
    void getNumberWhenPatternMatches() {
        int number = numberInterpreter.matchNumber(" _ | ||_|");
        assertEquals(0, number);
    }

    @Test
    void getNumberWhenPatternDoesNotMatch() {
        int number = numberInterpreter.matchNumber(" _   _|_|");
        assertEquals(-1, number);
    }


}