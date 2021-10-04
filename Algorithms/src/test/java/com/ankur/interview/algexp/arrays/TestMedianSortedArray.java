package com.ankur.interview.algexp.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMedianSortedArray {
    @Test
    public void testMedian() {
        int[] a = {1, 5, 8, 10, 18, 20};
        int[] b = {2, 3, 6, 7};
        double r = MedianSortedArrays.medianFromSortedArrays(a, b);
        Assertions.assertEquals(6.5, r);
    }
    @Test
    public void testMedian2() {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        double r = MedianSortedArrays.medianFromSortedArrays(x, y);
        Assertions.assertEquals(11, r);
    }
}
