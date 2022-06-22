package com.ankur.interview.algexp.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubSequenceSum {


    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        if(array.length==0){
            return result;
        }
        int[] max = array.clone();
        int[] index = new int[array.length];
        Arrays.fill(index,Integer.MIN_VALUE);
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && max[i]<=(max[j]+array[i])) {
                    max[i] = max[j] + array[i];
                    index[i] = j;
                }
            }
            if(max[i]>= max[k]){
                k=i;
            }
        }


        List<Integer> first = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        first.add(max[k]);
        result.add(first);
        result.add(rest);
        while (k != Integer.MIN_VALUE) {
            result.get(1).add(0,array[k]);
            k = index[k];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSumIncreasingSubsequence(new int[]{}));
        System.out.println(maxSumIncreasingSubsequence(new int[]{-1}));
        System.out.println(maxSumIncreasingSubsequence(new int[]{-1,1}));
        System.out.println(maxSumIncreasingSubsequence(new int[]{4, 6, 1, 3, 8, 4, 6}));

    }
}
