package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array.size()==0)
            return result;
        permuteHelper(0, array, result);
        return result;
    }

    private static void permuteHelper(int i, List<Integer> array, List<List<Integer>> result) {
        if (i >= array.size()) {
            result.add(new ArrayList<Integer>(array));
        }else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                permuteHelper(i + 1, array, result);
                swap(array, i, j);
            }
        }
    }


    private static void swap(List<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

}
