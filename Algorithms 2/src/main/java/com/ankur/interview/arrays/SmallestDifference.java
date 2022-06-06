package com.ankur.interview.arrays;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] a = {-1, 5, 10, 20, 28, 3};
        int[] b = {26, 134, 135, 15, 17};
        int[] result = smallestDifference(a, b);
        for (int i:result ) {
            System.out.print(i+" ");
        }    }


    private static int[] smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int x = 0, y = 0, smallest = Integer.MAX_VALUE, current = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (x < a.length && y < b.length) {
            int first = a[x];
            int second = b[y];
            if (first < second) {
                current = second - first;
                x++;
            } else if (first > second) {
                current = first - second;
                y++;
            } else {
                return new int[]{first, second};
            }
            if (smallest > current) {
                smallest = current;
                result = new int[]{first, second};
            }
        }
        return result;
    }
}
