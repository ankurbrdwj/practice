package com.ankur.interview.algexp.strings;

import com.ankur.interview.stdlib.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Containing {

    public static HashMap<Character, Integer> getCharCount(String small) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < small.length(); i++) {
            char key = small.charAt(i);
            if (!result.containsKey(key)) {
                result.put(key, 1);
            } else {
                result.put(key, result.get(key) + 1);
            }
        }
        return result;
    }

    public static String getSmallSubstring(HashMap<Character, Integer> frequency, String bigString) {

        Map<Character, Integer> currentMap = new HashMap<>();

        // total chars
        int uniqueCharCount = frequency.size();
        int uniqueCharDone = 0;
        // track indexes instead of characters
        List<Integer> bounds = new ArrayList<>();
        // sliding window technique
        int r = 0;
        int l = 0;
        while (r < bigString.length()) {
            Character currChar = bigString.charAt(r);
            // if not in  small string then move on
            if (!frequency.containsKey(currChar)) {
                r++;
                continue;
            }
            increaseCharCount(currentMap, currChar);

            if (currentMap.get(currChar).equals(frequency.get(currChar))) {
                uniqueCharDone++;
            }
            while (uniqueCharCount == uniqueCharDone && l <= r) {
                bounds = getCloserBounds(l, r, bounds.get(0), bounds.get(1));
                char leftChar = bigString.charAt(l);
                // not in small string move on
                if (!frequency.containsKey(leftChar)) {
                    l++;
                    continue;
                }
                if (currentMap.get(leftChar).equals(frequency.get(leftChar))) {
                    uniqueCharDone--;
                }
                decreaseCharCount(currentMap, leftChar);
                l++;
            }
            r++;
        }
        return getStringFromIndexes(bigString, bounds);
    }


    private static String getStringFromIndexes(String bigString, List<Integer> bounds) {
        int start = bounds.get(0);
        int end = bounds.get(1);
        if (end == Integer.MAX_VALUE)
            return "";
        else
            return bigString.substring(start, end + 1);
    }

    private static void decreaseCharCount(Map<Character, Integer> currentMap, char leftChar) {
        currentMap.put(leftChar, currentMap.get(leftChar) - 1);
    }

    private static void increaseCharCount(Map<Character, Integer> currentMap, Character currChar) {
        if (!currentMap.containsKey(currChar)) {
            currentMap.put(currChar, 1);
        } else {
            currentMap.put(currChar, currentMap.get(currChar) + 1);
        }
    }

    // get the smallest string
    private static List<Integer> getCloserBounds(int l, int r, Integer lower, Integer upper) {
        if (r - l < upper - lower) {
            return new ArrayList<>(Arrays.asList(l, r));
        } else {
            return new ArrayList<>(Arrays.asList(lower, upper));
        }
    }

    public static void main(String[] args) {
        Map<Character, Integer> frequency = getCharCount("$$abf");
        //String result = getSmallestSubstring();
    }

    public static String getSmallestSubstring(String abcd$ef$axb$c$, String $$abf) {
        // track current character count in bigString which are there in small string
        // 
        return null;
    }

    public static String getSmallestSubstring2(String bigString, String smallString) {
        int stringLength = bigString.length();
        int patternLength = smallString.length();

        if (stringLength < patternLength) {
            System.out.println("No such window exists");
            return "";
        }

        int no_of_chars = 256;
        int[] freqPattern = new int[no_of_chars];
        int[] freqString = new int[no_of_chars];

        // Store char freq of chars in smallString
        for (int i = 0; i < patternLength; i++)
            freqPattern[smallString.charAt(i)]++;

        int start = 0, start_index = -1,
                min_len = Integer.MAX_VALUE;

        // Start traversing the string
        // Count of characters
        int count = 0;
        for (int j = 0; j < stringLength; j++) {
            char currChar = bigString.charAt(j);
            // Count occurrence of characters
            // of string
            freqString[currChar]++;

            // If string's char matches
            // with pattern's char
            // then increment count
            if (freqString[currChar] <= freqPattern[currChar])
                count++;

            // If all the characters are matched
            if (count == patternLength) {

                // Try to minimize the window
                char charAtStart = bigString.charAt(start);
                // charAtStart is not required
                while (freqString[charAtStart] > freqPattern[charAtStart]
                        || freqPattern[charAtStart] == 0) {
                    //decrement from string till minimum
                    if (freqString[charAtStart] > freqPattern[charAtStart])
                        freqString[charAtStart]--;
                    start++;
                    charAtStart = bigString.charAt(start);
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting
        // from start_index
        // and length min_len
        return bigString.substring(start_index, start_index + min_len);
    }

}
