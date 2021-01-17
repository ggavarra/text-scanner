package com.dtp.digitalscanner.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberInterpreterTest {

    List<String> comparisonList = Arrays.asList(" _ | ||_|","     |  |"," _  _||_ "," _  _| _|","   |_|  |"," _ |_  _|"," _ |_ |_|"," _   |  |"," _ |_||_|"," _ |_| _|");
    NumberInterpreter numberInterpreter;
    
    @BeforeEach
    void setUp() {
        numberInterpreter = new NumberInterpreter();
    }

    @Test
    void getNumberWhenPatternMatches() {
        int number = numberInterpreter.getNumber(" _ | ||_|");
        assertEquals(0,number);
    }

    @Test
    void getNumberWhenPatternDosentMatch() {
        int number = numberInterpreter.getNumber(" _   _|_|");
        assertEquals(-1,number);
    }

    @Test
    void getAllNumbers() {
    }
}