package com.ankur.interview.algoexpert.dyanamicprogramming;

import com.ankur.interview.algoexpert.dynamicprogramming.CoinChangeProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMinCoin {
    private  CoinChangeProblem ccp;
    @BeforeEach
    public  void setUp(){
         ccp = new CoinChangeProblem();
    }

        @Test
        public void TestCase1() {
            int[] input = {1, 2, 3};
            Assertions.assertTrue(ccp.minCoinBottomUp(0, input) == 0);
        }

        @Test
        public void TestCase2() {
            int[] input = {2, 1};
            Assertions.assertTrue(ccp.minCoinBottomUp(3, input) == 2);
        }

        @Test
        public void TestCase3() {
            int[] input = {1, 5, 10};
            Assertions.assertTrue(ccp.minCoinBottomUp(4, input) == 4);
        }

        @Test
        public void TestCase4() {
            int[] input = {1, 5, 10};
            Assertions.assertTrue(ccp.minCoinBottomUp(7, input) == 3);
        }

        @Test
        public void TestCase5() {
            int[] input = {1, 5, 10};
            Assertions.assertTrue(ccp.minCoinBottomUp(10, input) == 1);
        }

        @Test
        public void TestCase6() {
            int[] input = {1, 5, 10};
            Assertions.assertTrue(ccp.minCoinBottomUp(11, input) == 2);
        }

        @Test
        public void TestCase7() {
            int[] input = {1, 5, 10};
            Assertions.assertTrue(ccp.minCoinBottomUp(24, input) == 6);
        }

        @Test
        public void TestCase8() {
            int[] input = {1, 5, 10};
            Assertions.assertTrue(ccp.minCoinBottomUp(25, input) == 3);
        }

        @Test
        public void TestCase9() {
            int[] input = {2, 4};
            Assertions.assertTrue(ccp.minCoinBottomUp(7, input) == -1);
        }

        @Test
        public void TestCase10() {
            int[] input = {3, 7};
            Assertions.assertTrue(ccp.minCoinBottomUp(7, input) == 1);
        }

        @Test
        public void TestCase11() {
            int[] input = {3, 5};
            Assertions.assertTrue(ccp.minCoinBottomUp(9, input) == 3);
        }

        @Test
        public void TestCase12() {
            int[] input = {3, 4, 5};
            Assertions.assertTrue(ccp.minCoinBottomUp(9, input) == 2);
        }

        @Test
        public void TestCase13() {
            int[] input = {39, 45, 130, 40, 4, 1};
            Assertions.assertTrue(ccp.minCoinBottomUp(135, input) == 3);
        }

        @Test
        public void TestCase14() {
            int[] input = {39, 45, 130, 40, 4, 1, 60, 75};
            Assertions.assertTrue(ccp.minCoinBottomUp(135, input) == 2);
        }
    }
