package com.ankur.interview.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestNonDupe {
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        char[] a = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], str.lastIndexOf(a[i]));
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            StringBuilder current = new StringBuilder();
            current.append(a[i]);
            for (int j = i + 1; j < a.length; j++) {
                if (current.toString().contains(String.valueOf(a[j])))
                    break;
                current.append(a[j]);
            }
            result = result.length() < current.length() ? current : result;
        }

        return result.toString();
    }

    public static String longestSubstringWithoutDuplication2(String str) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 1};
        int startIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (lastSeen.containsKey(c)) {
                startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
            }
            int previousLength = longest[1] - longest[0];
            int currentLength= i + 1 - startIdx;  // i is 0 based so add one and - last startIdx
            if (previousLength < currentLength ) {
                longest = new int[]{startIdx, i + 1};
            }
            lastSeen.put(c, i);
        }
        String result = str.substring(longest[0], longest[1]);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication2("clementisacap"));
    }
}


