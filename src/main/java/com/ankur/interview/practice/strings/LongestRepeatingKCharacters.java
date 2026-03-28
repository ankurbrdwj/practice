package com.ankur.interview.practice.strings;

public class LongestRepeatingKCharacters {
 /*
 /Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
            bbaaacddcaabdbd
            take first if reached min k stop .
            are there other characters in this ?
            what is there frequency ?
            go furthers isf we can find ne character with mink ,
            did we inf more characters
  */
    public static int getLongestStringWithMinKFrequency(String s, int k) {
        // Base case: if string is shorter than k, impossible
        if (s == null || s.length() < k) {
            return 0;
        }

        // Count frequency of each character
        int[] freq = new int[26]; // for 'a' to 'z'
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Find the first character that doesn't meet threshold k
        // This character is a "blocker" - it splits our string
        char blocker = 0;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] < k) {
                blocker = c;
                break;
            }
        }

        // If no blocker found, entire string is valid!
        if (blocker == 0) {
            return s.length();
        }

        // Split by blocker and recursively solve each part
        String[] parts = s.split(String.valueOf(blocker));
        int maxLength = 0;

        for (String part : parts) {
            maxLength = Math.max(maxLength, getLongestStringWithMinKFrequency(part, k));
        }

        return maxLength;
    }
}
