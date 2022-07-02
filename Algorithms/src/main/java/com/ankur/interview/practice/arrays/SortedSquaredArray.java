package com.ankur.interview.practice.arrays;

public class SortedSquaredArray {

    public static int[] sortedSquaredArray(int[] array) {
        int[] output = new int[array.length];
        int l = 0;
        int r = array.length - 1;
        int i = array.length - 1;
        while (l <= r) {
            int a = Math.abs(array[l]);
            int b = Math.abs(array[r]);
            if (a > b) {
                output[i] = (int) Math.pow(a,2);
                l++;
                i--;
            } else {
                output[i] = (int) Math.pow(b,2);
                r--;
                i--;
            }
        }
        // Write your code here.
        return output;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 8, 9};
        sortedSquaredArray(a);

    }
}
