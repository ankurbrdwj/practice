package com.ankur.interview.princeton.sorting.noncompare;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
        countSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    static void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        // frequencies
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        // positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //fill the output
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

}
