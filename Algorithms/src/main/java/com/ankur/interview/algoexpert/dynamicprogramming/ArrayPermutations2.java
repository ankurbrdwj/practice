package com.ankur.interview.algoexpert.dynamicprogramming;

import java.util.*;

public class ArrayPermutations2 {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array.size()==0)
            return result;
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (Integer item : array) {
            frequencyMap.compute(item, (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }
        int[] freq = new int[frequencyMap.size()];
        int[] values = new int[frequencyMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> item : frequencyMap.entrySet()) {
            freq[i] = item.getValue();
            values[i] = item.getKey();
            i++;
        }
        Integer[] branch = new Integer[array.size()];
        permuteHelper(values, freq, branch, 0, result);
        return result;
    }

    private static void permuteHelper(int[] values, int[] freq, Integer[] branch, int level, List<List<Integer>> result) {
        if (level == branch.length) {
            result.add(new ArrayList<>(Arrays.asList(branch)));
            //branch= new Integer[branch.length];
            return;
        }
        for (int j = 0; j < values.length; j++) {
            if (freq[j] == 0) {
                continue;
            }
            branch[level]= values[j];
            freq[j]--;
            permuteHelper(values, freq, branch, level + 1, result);
            freq[j]++;
        }
    }
}
