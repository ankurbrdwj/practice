package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoNumSum {
  //blind75

  public static void main(String[] args) {
        int[] input = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] result = twoPointerTechnique(input, 10);
        Arrays.stream(result).forEach(System.out::println);
    }


    public static int[] twoPointerTechnique(int[] a, int sum) {
        Arrays.sort(a);
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int currentSum = a[l] + a[r];
            if (currentSum == sum) {
                return new int[]{a[l], a[r]};
            } else if (currentSum < sum) {
                l++;
            } else if (currentSum > sum) {
                r--;
            }
        }
        return new int[0];
    }

    public static int[] twoNumSum(int[] array, int targetSum) {
        List<Integer> aux = new ArrayList<>();
        int[] result = array;
        while (result.length > 0) {
            int i = 0;
            boolean found = false;
            int x = result[i];
            int y = targetSum - x;
            for (int j = 1; j < result.length; j++) {
                if (result[j] == y) {
                    aux.add(x);
                    aux.add(result[j]);
                    found = true;
                    break;
                }
            }
            if (found) {
                result = deleteElement(result, x);
                result = deleteElement(result, y);
            } else {
                result = deleteElement(result, result[i]);
            }
        }
        return aux.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static int[] deleteElement(int[] arr, int element) {
        if (arr == null) {
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    /*
    /
     */
}
