package com.dtp.digitalscanner;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import com.dtp.digitalscanner.exception.InvalidPatternException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitalNumberScannerTest {

    DigitalNumberScanner scanner;

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("/SingleChunk.txt", "123456789" + "\n"),
                Arguments.of("/MultipleChunks.txt", "123456789" + "\n" + "123456789" + "\n" + "123456789" + "\n"),
                Arguments.of("/RandomPattern.txt", "1??4?????ILL" + "\n"),
                Arguments.of("/MultipleChunksWithIllegalRow.txt", "123456789\n" + "123456?89ILL" + "\n" + "123456789\n")
        );
    }

    @BeforeEach
    void setUp() {
        scanner = new DigitalNumberScanner();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void decodeFiles(String inputFileName, String expectedOutput) throws DigitalScannerValidationException, InvalidPatternException {
        String number = scanner.analyseAndPrint(inputFileName);
        assertEquals(expectedOutput, number);
    }
}