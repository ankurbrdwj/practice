package com.ankur.interview.adventofcode.Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Day2 {
    public static void main(String[] args) throws IOException {


        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day2/input.txt"));
        validPassword(data);
        policyPasswords(data);
    }
    private static void validPassword(List<String> data) {
        int count = 0; //var to maintain master valid pass count
        for (String s : data) {
            String pass = s.substring(s.lastIndexOf(' ')+1);
            int minCount = Integer.parseInt(s.substring(0, s.indexOf('-')));
            int maxCount = Integer.parseInt(s.substring(s.indexOf('-')+1, s.indexOf(' ')));
            String letterString = s.substring(s.indexOf(' ')+1, s.indexOf(':'));
            char letter = letterString.charAt(0);
            int currCount = 0;
            for (int i = 0; i < pass.length(); i++) {
                char temp = pass.charAt(i);
                if (letter == temp) currCount++;
            }
            if (currCount <= maxCount && currCount >= minCount)  currCount++;
        }
        System.out.println(count);
    }
    private static void policyPasswords(List<String> data) {
        int result = 0;
        for (String s : data) {
            String pass = s.substring(s.lastIndexOf(' ')+1);
            int firstIndex = Integer.parseInt(s.substring(0, s.indexOf('-')));
            int secondIndex = Integer.parseInt(s.substring(s.indexOf('-')+1, s.indexOf(' ')));
            String letterString = s.substring(s.indexOf(' ')+1, s.indexOf(':'));
            char letter = letterString.charAt(0);

            boolean first = pass.charAt(firstIndex-1) == letter;
            boolean second = pass.charAt(secondIndex-1) == letter;
            //if (first && second) continue;
             if (pass.charAt(firstIndex-1)!=pass.charAt(secondIndex-1) && (first || second)) result++;
        }
        System.out.println(result);
    }


}
