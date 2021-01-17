package com.dtp.digitalscanner.helper;

import com.dtp.digitalscanner.exception.InvalidPatternException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
public class NumberInterpreter {

    //represents 0-9 as string
    private static final String[] comparisonArray = {" _ | ||_|", "     |  |", " _  _||_ ", " _  _| _|", "   |_|  |", " _ |_  _|", " _ |_ |_|", " _   |  |", " _ |_||_|", " _ |_| _|"};

    final List<String> comparisonList = Arrays.asList(comparisonArray);

    public int matchNumber(String singleNumberPattern) {
        return comparisonList.indexOf(singleNumberPattern);
    }


    public List<String> getNumbersAsString(List<String> patternLines, int length) throws InvalidPatternException {

        List<String> numbersString = new ArrayList<>();
        for (int i = 0; i <= length - 3; i++) {
            String digitalNumAsString = patternLines.get(0).substring(i, i + 3) + patternLines.get(1).substring(i, i + 3) + patternLines.get(2).substring(i, i + 3);
            if (digitalNumAsString.length() != 9) {
                throw new InvalidPatternException(digitalNumAsString);
            }

            log.trace("i =" + i + ",length = " + digitalNumAsString.length() + "," + digitalNumAsString);
            numbersString.add(digitalNumAsString);
        }
        return numbersString;
    }
}
