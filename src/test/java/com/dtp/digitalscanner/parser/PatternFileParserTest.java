package com.dtp.digitalscanner.parser;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class PatternFileParserTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getNextNumberPatternLines() {
    }

    @Test
    void hasNextNumberPatternLine() {
    }

    @Test
    public void shouldReturnFirstThreePatternLines() throws DigitalScannerValidationException {
        PatternFileParser parser=new PatternFileParser("./src/main/resources/singleChunk.txt");
        List<String> numberLines=parser.getNextNumberPatternLines();
        assertThat(numberLines.size(), is(3));
    }

    @Test
    public void shouldReturnEmptyStringWhenFileIsEmpty() throws DigitalScannerValidationException {
        PatternFileParser parser=new PatternFileParser("./src/main/resources/Empty.txt");
        List<String> numberLines=parser.getNextNumberPatternLines();
        assertThat(numberLines.size(), is(0));
    }

    @Test
    public void shouldThrowDigitalScannerValidationException() throws DigitalScannerValidationException {
        PatternFileParser parser=new PatternFileParser("./src/main/resources/badFile.txt");
        //List<String> numberLines=parser.getNextNumberPatternLines();
        assertThrows(DigitalScannerValidationException.class, parser::getNextNumberPatternLines);
    }
}