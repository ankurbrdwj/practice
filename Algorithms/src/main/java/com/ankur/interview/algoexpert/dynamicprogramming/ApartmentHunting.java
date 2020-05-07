package com.ankur.interview.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        int[] maxDistance = new int[blocks.size()];
        for (int a = 0; a < maxDistance.length; a++) {
            maxDistance[a] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < blocks.size(); i++) {

            for (String req:reqs) {
                int closest = Integer.MAX_VALUE;
                for (int k = 0; k < blocks.size(); k++) {
                    Map<String, Boolean> block = blocks.get(k);
                    boolean requirementInThisBlock = block.get(reqs);
                    if (requirementInThisBlock) {
                        closest = Math.min(closest, disBetween(i, k));
                    }
                }
                maxDistance[i] = Math.max(maxDistance[i], closest);
            }
        }

        return getIndexAtMinValue(maxDistance);
    }

    private static int getIndexAtMinValue(int[] a) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            if (current < min) {
                min = current;
                index = i;
            }

        }
        return index;
    }

    private static int disBetween(int i, int j) {
        return Math.abs(i - j);
    }

    public static void main(String[] args) {
        List<Map<String, Boolean>> list = new ArrayList<>();
        list.add(Map.of(
                "gym", false,
                "school", true,
                "store", false
        ));
        list.add(Map.of(
                "gym", true,
                "school", false,
                "store", false
        ));
        list.add(Map.of(
                "gym", true,
                "school", true,
                "store", false
        ));
        list.add(Map.of(
                "gym", false,
                "school", true,
                "store", false
        ));
        list.add(Map.of(
                "gym", false,
                "school", true,
                "store", true
        ));
        String[] reqs = {"gym", "school", "store"};
        System.out.println(ApartmentHunting.apartmentHunting(list, reqs));
    }
}
