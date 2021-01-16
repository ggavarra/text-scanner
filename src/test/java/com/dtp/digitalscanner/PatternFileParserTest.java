package com.dtp.digitalscanner;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PatternFileParserTest {

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

}