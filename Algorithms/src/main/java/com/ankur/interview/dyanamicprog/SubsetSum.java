package com.ankur.interview.dyanamicprog;

public class SubsetSum {

    public static void main(String[] args) {

    }

    public static boolean hasSubSetSum(int[] input, int total) {
        boolean T[][] = new boolean[input.length + 1][total + 1];
        initializeArray(input, T);
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        return T[input.length][total];
    }

    public static boolean canBePartitioned(int[] arr,int target){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] T = new boolean[arr.length + 1][sum + 1];
        initializeArray(arr, T);
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j - arr[i - 1]] || T[i - 1][j];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[arr.length][sum];
    }

    private static void initializeArray(int[] arr, boolean[][] t) {
        for (int i = 0; i <= arr.length; i++) {
            t[i][0] = true;
        }
    }
}
