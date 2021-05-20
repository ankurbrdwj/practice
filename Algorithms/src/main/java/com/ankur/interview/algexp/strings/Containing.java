package com.ankur.interview.algexp.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Containing {

    public static HashMap<Character, Integer> getCharCount(String small) {
        HashMap<Character, Integer> result = new HashMap<>();
        char[] a = small.toCharArray();
        for (int i = 0; i < small.length(); i++)
            if (!result.containsKey(a[i])) result.put(a[i], 1);
            else result.put(a[i], result.get(a[i]) + 1);
        return result;
    }

    public static String getSmallestSubstring(HashMap<Character, Integer> frequency, String bigString) {
        // track current character count in bigString which are there in small string
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
        Map<Character,Integer> frequency=getCharCount("$$abf");
        //String result = getSmallestSubstring();
    }
}
