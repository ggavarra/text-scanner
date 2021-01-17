package com.dtp.digitalscanner;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import com.dtp.digitalscanner.exception.InvalidPatternException;
import com.dtp.digitalscanner.helper.NumberInterpreter;
import com.dtp.digitalscanner.parser.PatternFileParser;

import java.util.List;

public class DigitalNumberScanner {

    public String analyseAndPrint(String filePath) throws DigitalScannerValidationException, InvalidPatternException {
        PatternFileParser parser = new PatternFileParser(filePath);
        NumberInterpreter numberInterpreter = new NumberInterpreter();
        StringBuilder builder = new StringBuilder();
        while (parser.hasNextNumberPatternLine()) {

            List<String> numberCodesString = numberInterpreter.getNumbersAsString(parser.getNextNumberPatternLines(), 27);
            if (numberCodesString != null) {
                numberCodesString.forEach(numberCode -> {
                    int number = numberInterpreter.matchNumber(numberCode);
                    if (number > -1) {
                        builder.append(number);
                    }
                });
            }
            builder.append("\n");

        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
