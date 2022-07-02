package com.ankur.interview.princeton.sorting.elementarysorts;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 8, 3, 88, 22, 66, 55, 33, 0, 2, 6, 4, 3, 67, 8, 2, 2, 5, 7};
        int[] result = insertionSort(a);
        Arrays.stream(result).mapToObj(i -> i + " ").forEach(System.out::print);
    }

    private static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                Util.swap(j, j - 1, a);
                j--;
            }
        }
        return a;
    }
}
