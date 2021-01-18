package com.dtp.digitalscanner.parser;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PatternFileParserTest {

    @Test
    public void shouldReturnFirstThreePatternLines() throws DigitalScannerValidationException {
        PatternFileParser parser = new PatternFileParser("/SingleChunk.txt");
        List<String> numberLines = parser.getNextNumberPatternLines();
        assertThat(numberLines.size(), is(3));
    }

    @Test
    public void canHandleMultipleChunks() throws DigitalScannerValidationException {
        PatternFileParser parser = new PatternFileParser("/MultipleChunksWithIllegalRow.txt");
        List<String> numberLines = new ArrayList<>();
        while (parser.hasNextNumberPatternLine()) {
            numberLines.addAll(parser.getNextNumberPatternLines());
        }
        assertThat(numberLines.size(), is(9));
    }

    @Test
    public void shouldReturnEmptyStringWhenFileIsEmpty() throws DigitalScannerValidationException {
        PatternFileParser parser = new PatternFileParser("/Empty.txt");
        List<String> numberLines = parser.getNextNumberPatternLines();
        assertThat(numberLines.size(), is(0));
    }

    @Test
    public void shouldThrowDigitalScannerValidationException() {
        PatternFileParser parser = new PatternFileParser("/BadFile.txt");
        assertThrows(DigitalScannerValidationException.class, parser::getNextNumberPatternLines);
    }
}