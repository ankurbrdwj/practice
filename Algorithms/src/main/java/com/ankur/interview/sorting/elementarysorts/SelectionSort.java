package com.ankur.interview.sorting.elementarysorts;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 8, 3, 88, 22, 66, 55, 33, 0, 2, 6, 4, 3, 67, 8, 2, 2, 5, 7};
        int[] result = selectionSort(a);
        Arrays.stream(result).mapToObj(i -> i + " ").forEach(System.out::print);
    }

    private static int[] selectionSort(int[] a) {
        int currIdx = 0;
        while (currIdx < a.length - 1) {
            int smallIdx = currIdx;
            for (int i = currIdx + 1; i < a.length; i++) {
                if (a[smallIdx] > a[i]) {
                    smallIdx = i;
                }
            }
            Util.swap(currIdx, smallIdx, a);
            currIdx++;
        }
        return a;
    }
}
