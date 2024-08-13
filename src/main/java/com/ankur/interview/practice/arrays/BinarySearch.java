package com.ankur.interview.practice.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearch {

    public static int search(int[] array, int target) {
        // Write your code here.
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        while (low < high) {
            if (target == array[mid]) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] a, int target) {
        Arrays.sort(a);
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                l = mid + 1;
            } else if (a[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,622,33,44,33,54};
        int r= binarySearch(a,33);
        System.out.println(r);
        System.out.println(isASquare(16));
    }

    public static boolean isASquare(int a){
        int[] x = IntStream.range(1, a).toArray();
        int l = 0;
        int r = x.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a == Math.pow(x[mid],2)) {
                return true;
            } else if ( Math.pow(x[mid],2) < a) {
                l = mid + 1;
            } else if (Math.pow(x[mid],2) > a) {
                r = mid - 1;
            }
        }
        return false;
    }

}



