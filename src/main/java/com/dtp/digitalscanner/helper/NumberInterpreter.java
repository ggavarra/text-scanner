package com.dtp.digitalscanner.helper;

import com.dtp.digitalscanner.exception.InvalidPatternException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NumberInterpreter {

    //represents 0-9 as string
    private static final String[] comparisonArray = {" _ | ||_|","     |  |"," _  _||_ "," _  _| _|","   |_|  |"," _ |_  _|"," _ |_ |_|"," _   |  |"," _ |_||_|"," _ |_| _|"};

    final List<String> comparisonList = Arrays.asList(comparisonArray);

    public int getNumber(String singleNumberpattern){
        return comparisonList.indexOf(singleNumberpattern);
    }


    public List<String> getAllNumbers(List<String> patternLines ,int length) throws InvalidPatternException {

        List<String> numbersString=new ArrayList<>();
        for (int i = 0; i <=length- 3; i++) {
            System.out.println("i ="+i+", "+patternLines.get(0).length()+","+patternLines.get(1).length()+","+patternLines.get(2).length());
            String digitalNumAsString=patternLines.get(0).substring(i,i+3)+patternLines.get(1).substring(i,i+3)+patternLines.get(2).substring(i,i+3);
            if(digitalNumAsString.length()!=9)
            {
                throw new InvalidPatternException(digitalNumAsString);
            }

            System.out.println("i ="+i+",length = "+digitalNumAsString.length()+","+digitalNumAsString);
            numbersString.add(digitalNumAsString);
        }
        return numbersString;
    }
}
