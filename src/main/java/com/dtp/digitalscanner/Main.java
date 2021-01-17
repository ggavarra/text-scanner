package com.dtp.digitalscanner;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import com.dtp.digitalscanner.exception.InvalidPatternException;

public class Main {
    public static void main(String[] args) throws DigitalScannerValidationException {
        try {
            new DigitalNumberScanner().analyseAndPrint("/SingleChunk.txt");
        } catch (InvalidPatternException e) {
            e.printStackTrace();
        }
    }
}
