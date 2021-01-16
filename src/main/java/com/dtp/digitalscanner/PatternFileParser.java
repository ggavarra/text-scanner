package com.dtp.digitalscanner;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import com.dtp.digitalscanner.validation.BaseValidator;
import com.dtp.digitalscanner.validation.Validator;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternFileParser {

    private Scanner scanner;
    private Validator validator;

    public PatternFileParser(String filePath, Validator validator) {
        try {
            this.scanner = new Scanner(new File(filePath)).useDelimiter("\n");

            this.validator=validator;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PatternFileParser(String filePath) {
        this(filePath, new BaseValidator());
    }

    public List<String> getNextNumberPatternLines() throws DigitalScannerValidationException {

        List<String> numberLines = new ArrayList<>();
        String line = getNextLine();
        while (!isLineSeparator(line)) {
            numberLines.add(line);
            line = getNextLine();
            validator.validate(line);
        }
        return numberLines;
    }

    private boolean isLineSeparator(String line) {
        return line.isEmpty();
    }

    private String getNextLine() {
        if (scanner.hasNext()) {
            return scanner.nextLine();
        }
        return "";
    }


    public boolean hasNextNumberPatternLine() {
        return scanner.hasNextLine() ;
    }
}
