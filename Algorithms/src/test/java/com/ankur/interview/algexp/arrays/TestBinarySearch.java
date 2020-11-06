package com.ankur.interview.algexp.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBinarySearch {

    @Test
    public void TestCase1() {
        Assertions.assertTrue(BinarySearch.search(new int[]{1, 5, 23, 111}, 111) == 3);
    }

    @Test
    public void TestCase2() {
        Assertions.assertTrue(BinarySearch.search(new int[]{1, 5, 23, 111}, 5) == 1);
    }

    @Test
    public void TestCase3() {
        Assertions.assertTrue(BinarySearch.search(new int[]{1, 5, 23, 111}, 35) == -1);
    }

    @Test
    public void TestCase4() {
        Assertions.assertTrue(
                BinarySearch.search(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33) == 3);
    }

    @Test
    public void TestCase5() {
        Assertions.assertTrue(
                BinarySearch.search(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 72) == 8);
    }

    @Test
    public void TestCase6() {
        Assertions.assertTrue(
                BinarySearch.search(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 73) == 9);
    }

    @Test
    public void TestCase7() {
        Assertions.assertTrue(
                BinarySearch.search(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 70) == -1);
    }

    @Test
    public void TestCase8() {
        Assertions.assertTrue(
                BinarySearch.search(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73, 355}, 355) == 10);
    }

    @Test
    public void TestCase9() {
        Assertions.assertTrue(
                BinarySearch.search(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73, 355}, 354) == -1);
    }
}
