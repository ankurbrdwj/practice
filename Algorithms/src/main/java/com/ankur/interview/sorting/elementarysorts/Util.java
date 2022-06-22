package com.ankur.interview.sorting.elementarysorts;

public class Util {
    public static void swap(int i, int i1, int[] a) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }
}
