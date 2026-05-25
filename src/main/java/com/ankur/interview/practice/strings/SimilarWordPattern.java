package com.ankur.interview.practice.strings;

import java.util.*;

public class SimilarWordPattern {

    public static List<String> findSimilarPatterns(List<String> words, String target) {
        int[] targetPattern = encode(target);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == target.length() && Arrays.equals(encode(word), targetPattern)) {
                result.add(word);
            }
        }
        return result;
    }

    // Replace each char with the index of its first occurrence in the word.
    // Two words are structurally identical iff their encoded arrays are equal.
    private static int[] encode(String word) {
        int[] pattern = new int[word.length()];
        Map<Character, Integer> firstSeen = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            firstSeen.putIfAbsent(c, i);
            pattern[i] = firstSeen.get(c);
        }
        return pattern;
    }
}