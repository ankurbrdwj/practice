package com.ankur.interview.practice.popular;

public class WonderfulSubstringsBrute {

    /*
     * BRUTE FORCE: Check every substring, count odd-frequency letters.
     *
     * For each starting index i, expand right to j, maintaining a freq
     * array. After each expansion check if at most one letter is odd.
     *
     * "aab"  substrings:
     *
     *   i=0: "a"   freq[a]=1 → 1 odd  → ✓
     *         "aa"  freq[a]=2 → 0 odd  → ✓
     *         "aab" freq[a]=2,freq[b]=1 → 1 odd → ✓
     *   i=1: "a"   freq[a]=1 → 1 odd  → ✓
     *         "ab"  freq[a]=1,freq[b]=1 → 2 odd → ✗
     *   i=2: "b"   freq[b]=1 → 1 odd  → ✓
     *
     *   count = 5
     *
     * Time : O(n²) — every substring visited once
     * Space: O(1)  — freq array is fixed size 10
     */

    public static long wonderfulSubstrings(String word) {
        long count = 0;

        for (int i = 0; i < word.length(); i++) {
            int[] freq = new int[10]; // freq of 'a'..'j'

            for (int j = i; j < word.length(); j++) {
                freq[word.charAt(j) - 'a']++;

                if (isWonderful(freq)) count++;
            }
        }

        return count;
    }

    private static boolean isWonderful(int[] freq) {
        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) oddCount++;
        }
        return oddCount <= 1;
    }
}