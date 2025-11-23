package com.ankur.interview.practice.strings;

public class DramatizeString {
    public static String processString(String input) {
        String temp= addExclamations(input);
        String result = replacePeriods(temp);
        return result;
    }

    private static String replacePeriods(String temp) {
        return temp.replaceAll("\\.","!");
    }

    private static String addExclamations(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            char current = input.charAt(i);
            result.append(current);

            // If current char is '!', check for consecutive exclamations
            if (current == '!') {
                int j = i + 1;
                // Count consecutive exclamations
                while (j < input.length() && input.charAt(j) == '!') {
                    result.append(input.charAt(j));
                    j++;
                }
                // Add one more '!' after the group
                result.append('!');
                i = j; // Move index to after the group
            } else {
                i++;
            }
        }
        return result.toString();
    }
}
