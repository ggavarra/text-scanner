package com.dtp.digitalscanner.parser;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import com.dtp.digitalscanner.validation.BaseValidator;
import com.dtp.digitalscanner.validation.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class PatternFileParser {

    private final Scanner scanner;
    private final Validator validator;

    public PatternFileParser(String filePath, Validator validator) {
        this.scanner = new Scanner(getClass().getResourceAsStream(filePath)).useDelimiter("\n");
        this.validator = validator;

    }

    public PatternFileParser(String filePath) {
        this(filePath, new BaseValidator());
    }

    public List<String> getNextNumberPatternLines() throws DigitalScannerValidationException {

        List<String> numberLines = new ArrayList<>();
        String line = getNextLine();
        boolean isValidationSuccess = false;
        while (!isLineSeparator(line)) {
            isValidationSuccess = validator.validate(line);
            if (!isValidationSuccess) {
                numberLines = new ArrayList<>();
                numberLines.add("Bad input");
            } else {
                numberLines.add(line);
            }
            line = getNextLine();
        }
        return numberLines;
    }

    private boolean isLineSeparator(String line) {
        return line.isEmpty();
    }

    private String getNextLine() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }

    public boolean hasNextNumberPatternLine() {
        return scanner.hasNextLine();
    }
}
