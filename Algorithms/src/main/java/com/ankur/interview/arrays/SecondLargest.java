package com.ankur.interview.arrays;

/*
find second largest element in an array /
 */
public class SecondLargest {
    public static void main(String[] args) {
        int[] input = {-3, -7, -10, 3, 5, 3, 1, 8, 9, 20};
        int result = findSecondLargestElement(input);
        System.out.println(result);
    }

    private static int findSecondLargestElement(int[] input) {
        int first = input[0];
        int second = input[0];
        for (int i = 0; i < input.length; i++) {
            if (first < input[i]) {
                second = first;
                first = input[i];
            }
        }
        return second;
    }
}
