package com.dtp.digitalscanner;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import com.dtp.digitalscanner.exception.InvalidPatternException;
import com.dtp.digitalscanner.helper.NumberInterpreter;
import com.dtp.digitalscanner.parser.PatternFileParser;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DigitalNumberScanner {

    public String analyseAndPrint(String filePath) throws DigitalScannerValidationException, InvalidPatternException {
        PatternFileParser parser = new PatternFileParser(filePath);
        NumberInterpreter numberInterpreter = new NumberInterpreter();
        StringBuilder builder = new StringBuilder();
        AtomicInteger invalidCharCountPerLine = new AtomicInteger(0);
        while (parser.hasNextNumberPatternLine()) {

            List<String> numberCodesString = numberInterpreter.getNumbersAsString(parser.getNextNumberPatternLines(), 27);
            invalidCharCountPerLine.set(0);
            if (numberCodesString != null) {
                numberCodesString.forEach((numberCode) -> {
                    String number = numberInterpreter.matchNumberAsString(numberCode);
                    if (number == "?") invalidCharCountPerLine.incrementAndGet();
                    builder.append(number);
                });
            }

            if (invalidCharCountPerLine.get() > 0) {
                builder.append("ILL");
            }
            builder.append("\n");

        }
        System.out.println(builder.toString());
        return builder.toString();
    }

}
