package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TestSimilarWordPattern {

    @Test
    void testBasicCase() {
        List<String> words = Arrays.asList("aabbcc", "aakkff", "akkffkk", "tjjiijj", "deftg");
        List<String> result = SimilarWordPattern.findSimilarPatterns(words, "mnnssnn");
        Assertions.assertEquals(Arrays.asList("akkffkk", "tjjiijj"), result);
    }

    @Test
    void testNoMatch() {
        List<String> words = Arrays.asList("aabbcc", "aakkff", "deftg");
        List<String> result = SimilarWordPattern.findSimilarPatterns(words, "mnnssnn");
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void testAllDistinctChars() {
        // "abc" pattern [0,1,2] — only words with all unique chars match
        List<String> words = Arrays.asList("xyz", "xxy", "pqr");
        List<String> result = SimilarWordPattern.findSimilarPatterns(words, "abc");
        Assertions.assertEquals(Arrays.asList("xyz", "pqr"), result);
    }
}