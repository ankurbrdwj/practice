package com.ankur.interview.princeton.sorting.elementarysorts;

import java.util.Arrays;

/*
most naive sorting/
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 3, 8, 3, 88, 22, 66, 55, 33, 0, 2, 6, 4, 3, 67, 8, 2, 2, 5, 7};
        int[] result = bubbleSort(a);
        Arrays.stream(result).mapToObj(i -> i + " ").forEach(System.out::print);
    }

    private static int[] bubbleSort(int[] a) {
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length - counter-1; i++) {
                if (a[i] > a[i + 1])
                    Util.swap(i, i + 1, a);
                isSorted = false;
            }
            counter++;
        }
        return a;
    }


}
