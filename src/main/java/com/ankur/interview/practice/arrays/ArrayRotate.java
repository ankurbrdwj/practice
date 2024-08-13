package com.ankur.interview.practice.arrays;

import java.util.Arrays;

public class ArrayRotate {

    public static void main(String... args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        leftRotateReversal(a, 4);
        System.out.println(Arrays.toString(a));
    }

    public static int[] leftRotate(int[] a, int k) {
         /* To get the starting point of
        rotated array */
        int n = a.length;
        int mod = k % n;

        // Prints the rotated array from
        // start position
        int[] result = new int[a.length];
        for (int i = 0; i < n; i++) {
            System.out.print(a[(i + mod) % n] + " ");
            result[i] = a[(i + mod) % n];
        }
        System.out.println();
        return result;
    }

    public static int[] rightRotate(int[] a, int k) {
        int n = a.length;
        int mod = k % n;
        int[] result = new int[a.length];
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(a[(i + mod) % n]
                    + " ");
            result[(i + mod) % n] = a[i];
        }
        System.out.println();
        return result;
    }

    public static void leftRotateBlockSwap(int[] arr, int d, int n) {
        if (d == 0 || d == n) {
            return;
        }
        int i = d;
        int j = n - d;
        while (i != j) {
            if (i <= j) {
                swap(arr, d - i, d + j - i, i);
                j -= i;
            } else {
                swap(arr, d - i, d, j);
                i -= j;
            }
        }
        swap(arr, d - i, d, i);
    }


    private static void swap(int arr[], int fi,
                             int si, int d) {
        int i, temp;
        for (i = 0; i < d; i++) {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }
    public static void leftRotateReversal(int arr[], int d)
    {

        if (d == 0)
            return;
        int n = arr.length;
        rvereseArray(arr, 0, d - 1);
        rvereseArray(arr, d, n - 1);
        rvereseArray(arr, 0, n - 1);
    }

    /*Function to reverse arr[] from index start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
