package com.ankur.interview.practice.dynamicprogramming;

public class PrintSumElements {
    static void includeElement(int a[],
                               int n, int sum)
    {
        for (int i = 0; i < n; i++)
        {

            // Check if the current element
            // will be included or not
            if ((sum - a[i]) >= 0)
            {
                sum = sum - a[i];
                System.out.print(a[i] + " ");
            }
        }
    }
    public static void main(String[] args)
    {
        int arr[] = { 3, 5, 3, 2 };
        int n = arr.length;
        int sum = 9;

        includeElement(arr, n, sum);
    }
}
