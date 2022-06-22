package com.ankur.interview.algexp.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pattern {
    public static void main(String[] args) {
        String[] result = patternMatcher("xyxy", "abab");
        Arrays.stream(result).forEach(System.out::println);
    }

    private static String[] patternMatcher(String pattern, String input) {
        // work on pattern first and fixPattern alwways xxyxxy
        // countandfirstHY and how long each x and y is in actual string
        // buildPotentialMatch
        if (pattern.length() > input.length()) {
            return new String[]{};
        }
        char[] fixPattern = fixPattern(pattern.toCharArray());
        boolean didSwitch = fixPattern[0] != pattern.charAt(0);
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('x', 0);
        counts.put('y', 0);
        int firstY = countAndFirstYinPattern(fixPattern, counts);
        if (counts.get('y') != 0) {
            for (int xLen = 1; xLen < input.length(); xLen++) {
                double yLen = ((double) input.length() - counts.get('x') * xLen) / (double) counts.get('y');
                if (yLen <= 0 || yLen % 1 != 0) { // decimal yLen thn skip
                    continue;
                }
                int yLength = (int) yLen;
                int yIndex = firstY * xLen;
                String x = input.substring(0, xLen);
                String y = input.substring(yIndex, yIndex + yLength);
                String potentialMatch = buildPotentialMatch(fixPattern, x, y);
                if (input.equals(potentialMatch)) {
                    return didSwitch ? new String[]{y, x} : new String[]{x, y};
                }
            }
        } else {
            double xLen = input.length() / counts.get('x');
            if (xLen % 1 == 0) {
                String x = input.substring(0, (int) xLen);
                String potentialMatch = buildPotentialMatch(fixPattern, x, null);
                if (input.equals(potentialMatch)) {
                    return didSwitch ? new String[]{"", x} : new String[]{x, ""};
                }
            }
        }
        return new String[]{};
    }

    private static String buildPotentialMatch(char[] fixPattern, String x, String y) {
        StringBuilder match = new StringBuilder();
        for (char c : fixPattern) {
            if (c == 'x') {
                match.append(x);
            } else {
                match.append(y);
            }
        }
        return match.toString();
    }

    private static int countAndFirstYinPattern(char[] fixPattern, Map<Character, Integer> counts) {
        int firstY = -1;
        for (int i = 0; i < fixPattern.length; i++) {
            char c = fixPattern[i];
            counts.put(c, counts.get(c) + 1);
            if (c == 'y' && firstY == -1) {
                firstY = i;
            }
        }
        return firstY;
    }

    private static char[] fixPattern(char[] pattern) {
        if (pattern[0] == 'x') {
            return pattern;
        } else {
            for (int i = 0; i < pattern.length; i++) {
                if (pattern[i] == 'y') {
                    pattern[i] = 'x';
                } else {
                    pattern[i] = 'y';
                }
            }
        }
        return pattern;
    }
}