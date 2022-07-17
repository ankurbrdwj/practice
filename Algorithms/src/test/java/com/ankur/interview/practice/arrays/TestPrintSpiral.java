package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestPrintSpiral {

        @Test
        public void TestCase1() {
            var input =
                    new int[][] {
                            {1},
                    };
            var expected = Arrays.asList(1);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase2() {
            var input =
                    new int[][] {
                            {1, 2},
                            {4, 3},
                    };
            var expected = Arrays.asList(1, 2, 3, 4);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase3() {
            var input =
                    new int[][] {
                            {1, 2, 3},
                            {8, 9, 4},
                            {7, 6, 5},
                    };
            var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase4() {
            var input =
                    new int[][] {
                            {1, 2, 3, 4},
                            {12, 13, 14, 5},
                            {11, 16, 15, 6},
                            {10, 9, 8, 7},
                    };
            var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase5() {
            var input =
                    new int[][] {
                            {1, 2, 3, 4, 5, 6},
                            {20, 21, 22, 23, 24, 7},
                            {19, 32, 33, 34, 25, 8},
                            {18, 31, 36, 35, 26, 9},
                            {17, 30, 29, 28, 27, 10},
                            {16, 15, 14, 13, 12, 11},
                    };
            var expected =
                    Arrays.asList(
                            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                            25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase6() {
            var input =
                    new int[][] {
                            {1, 2, 3, 4, 5, 6, 7, 8, 9},
                            {22, 23, 24, 25, 26, 27, 28, 29, 10},
                            {21, 36, 35, 34, 33, 32, 31, 30, 11},
                            {20, 19, 18, 17, 16, 15, 14, 13, 12},
                    };
            var expected =
                    Arrays.asList(
                            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                            25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase7() {
            var input =
                    new int[][] {
                            {1, 2, 3, 4},
                            {22, 23, 24, 5},
                            {21, 36, 25, 6},
                            {20, 35, 26, 7},
                            {19, 34, 27, 8},
                            {18, 33, 28, 9},
                            {17, 32, 29, 10},
                            {16, 31, 30, 11},
                            {15, 14, 13, 12},
                    };
            var expected =
                    Arrays.asList(
                            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                            25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase8() {
            var input =
                    new int[][] {
                            {1, 2, 3, 4},
                            {10, 11, 12, 5},
                            {9, 8, 7, 6},
                    };
            var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void TestCase9() {
            var input =
                    new int[][] {
                            {1, 2, 3},
                            {12, 13, 4},
                            {11, 14, 5},
                            {10, 15, 6},
                            {9, 8, 7},
                    };
            var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
            var actual = PrintSpiralMatrix.spiralTraverse(input);
            Assertions.assertTrue(expected.equals(actual));
        }
    }
