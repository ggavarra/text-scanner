package com.dtp.digitalscanner;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import com.dtp.digitalscanner.exception.InvalidPatternException;

import java.util.List;

public class DigitalNumberScanner {
    public static void main(String[] args) throws DigitalScannerValidationException {
        //PatternFileParser patternFileReader = new PatternFileParser("./src/main/resources/singleChunk.txt");
        PatternFileParser patternFileReader = new PatternFileParser("./src/main/resources/multipleChunks.txt");
        //PatternFileParser patternFileReader = new PatternFileParser("./src/main/resources/multipleChunksWithIllegalRow.txt");
        NumberInterpreter numberInterpreter = new NumberInterpreter();
        while(patternFileReader.hasNextNumberPatternLine()){
            List<String> nextNumberPatternLines = patternFileReader.getNextNumberPatternLines();

            List<String> singleChunkNumbers = null;
            try {
                singleChunkNumbers = numberInterpreter.getAllNumbers(nextNumberPatternLines,27);
            } catch (InvalidPatternException e) {
                e.printStackTrace();
            }
            singleChunkNumbers.forEach(singleChunk -> {
                    int number=numberInterpreter.getNumber(singleChunk);
                    if(number>-1) {
                        System.out.print(numberInterpreter.getNumber(singleChunk));
                    }
                });

            }
            System.out.println("");
        }

}
