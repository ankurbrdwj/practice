package com.ankur.interview.algoexpert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMaxPeakLength {

        @Test
        public void TestCase1() {
            var input = new int[] {};
            var expected = 0;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase2() {
            var input = new int[] {1, 3, 2};
            var expected = 3;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase3() {
            var input = new int[] {1, 2, 3, 4, 5, 1};
            var expected = 6;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase4() {
            var input = new int[] {5, 4, 3, 2, 1, 2, 1};
            var expected = 3;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase5() {
            var input = new int[] {5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10};
            var expected = 5;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase6() {
            var input = new int[] {5, 4, 3, 2, 1, 2, 10, 12};
            var expected = 0;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase7() {
            var input = new int[] {1, 2, 3, 4, 5, 6, 10, 100, 1000};
            var expected = 0;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase8() {
            var input = new int[] {1, 2, 3, 3, 2, 1};
            var expected = 0;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase9() {
            var input = new int[] {1, 1, 3, 2, 1};
            var expected = 4;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase10() {
            var input = new int[] {1, 2, 3, 2, 1, 1};
            var expected = 5;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase11() {
            var input =
                    new int[] {
                            1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1
                    };
            var expected = 9;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }

        @Test
        public void TestCase12() {
            var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
            var expected = 6;
            var actual = FindMaxPeakLength.longestPeak(input);
            Assertions.assertTrue(expected == actual);
        }
    }
