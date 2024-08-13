package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.LevenshteinDistance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLevenshtienDistance {
    // Add, edit, or remove tests in this file.
// Treat it as your playground!
     @Test
        public void TestCase1() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("", "") == 0);
        }

        @Test
        public void TestCase2() {
           // TODO Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("", "abc") == 3);
        }

        @Test
        public void TestCase3() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abc", "abc") == 0);
        }

        @Test
        public void TestCase4() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abc", "abx") == 1);
        }

        @Test
        public void TestCase5() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abc", "abcx") == 1);
        }

        @Test
        public void TestCase6() {
          // TODO   Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abc", "yabcx") == 2);
        }

        @Test
        public void TestCase7() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("algoexpert", "algozexpert") == 1);
        }

        @Test
        public void TestCase8() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abcdefghij", "1234567890") == 10);
        }

        @Test
        public void TestCase9() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abcdefghij", "a234567890") == 9);
        }

        @Test
        public void TestCase10() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("biting", "mitten") == 4);
        }

        @Test
        public void TestCase11() {
            // TODO Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("cereal", "saturday") == 6);
        }

        @Test
        public void TestCase12() {
           // TODO Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("cereal", "saturdzz") == 7);
        }

        @Test
        public void TestCase13() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abbbbbbbbb", "bbbbbbbbba") == 2);
        }

        @Test
        public void TestCase14() {
            // TODO Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("abc", "yabd") == 2);
        }

        @Test
        public void TestCase15() {
            Assertions.assertTrue(LevenshteinDistance.levenshteinDistance("xabc", "abcx") == 2);
        }
    }

