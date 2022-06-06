package com.ankur.interview.codejam.arrays;

import java.util.Scanner;

public class ReverseSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int n = scan.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = scan.nextInt();
            }
            reversSort(array);
        }

    }

    private static void reversSort(int[] array) {
        int j = getMin(array);


    }

    private static int getMin(int[] array) {
        int min=Integer.MAX_VALUE;
        /*int minIndex= Integer.MAX_VALUE;
        for (int k = 0; k < array.length; k++) {
            if()
            min= Math.min(array[k],min);

        }*/
return min;
    }
}
