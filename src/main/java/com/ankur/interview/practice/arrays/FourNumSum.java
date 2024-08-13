package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourNumSum {
    public static void main(String[] args) {
        int[] a = {-4,-3,-2,-1,1,2,3,4};
        int target = 0;
        ArrayList<Integer[]> result = getQuadruplets(a, target);
        for (Integer[] i:result) {
            System.out.print("[ ");
            for (Integer k: i) {
                System.out.print(k+" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    private static ArrayList<Integer[]> getQuadruplets(int[] a, int target) {
        Arrays.sort(a);
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        ArrayList<Integer[]> result = new ArrayList<>();
        int currentSum = 0, diff = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                currentSum = a[i] + a[j];
                diff = target - currentSum;
                if (map.containsKey(diff)) {
                    for (Pair p : map.get(diff)) {
                        result.add(new Integer[]{p.getX(), p.getY(), a[i], a[j]});
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                currentSum = a[i] + a[k];
                if (!map.containsKey(currentSum)) {
                    List<Pair> list = new ArrayList<>();
                    list.add(new Pair(a[i], a[k]));
                    map.put(currentSum, list);
                } else {
                    map.get(currentSum).add(new Pair(a[i], a[k]));
                }
            }
        }
        return result;
    }

}
