package com.ankur.interview.practice.dynamicprogramming;

/*
Given an Array fins maximum sum from non adjacent numbers
 */
public class MaxSubSetNonAdjacent {
    public static void main(String[] args) {
        //int[] a={75, 105, 120, 75, 90, 135};
        int[]a={};
        System.out.println(maxSumNonAdj(a));
    }

    public static int maxSumNonAdj(int[] a) {
        int incl = a[0];
        int excl = 0;
        for (int i = 1; i < a.length; i++) {
            int temp = incl;
            incl = Math.max(excl + a[i], incl);
            excl = temp;
        }
        return incl;
    }
}
