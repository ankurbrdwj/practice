package com.ankur.interview.algoexpert.arrays;

public class FindMaxPeakLength {
    public static int longestPeak(int[] a) {
        // Write your code here.
        int count = 0;
        for (int i = 1; i <= a.length - 2; i++) {
            if (a[i - 1] < a[i] && a[i] > a[i + 1]) { // there is peak
                int currentLength = getMountainLength(a, i);
                if (currentLength > count) {
                    count = currentLength;
                }
            }
        }
        return count;
    }

    private static int getMountainLength(int[] a, int i) {
        int left = 0;
        int right = 0;
        for (int j = i; j > 0; j--) {
            if (a[j] > a[j - 1])
                left++;
            else
                break;
        }
        for (int j = i; j <= a.length - 2; j++) {
            if (a[j] > a[j + 1])
                right++;
            else
                break;
        }
        return left + right + 1;
    }
}
