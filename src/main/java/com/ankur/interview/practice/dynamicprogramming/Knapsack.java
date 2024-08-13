package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    // Write your code here.
    // Replace the code below.
    int[][] knapsack = new int[items.length + 1][capacity + 1];
    for (int i = 1; i < items.length + 1; i++) {
      int currentValue = items[i - 1][0];
      int currentWeight = items[i - 1][1];
      for (int c = 0; c < capacity + 1; c++) {
        if (currentWeight > c) {
          knapsack[i][c] = knapsack[i - 1][c];
        } else {
          knapsack[i][c] = Math.max(knapsack[i - 1][c]
            , (knapsack[i - 1][c - currentWeight] + currentValue));
        }
      }
    }
    List<List<Integer>> result = getKnapSackValues(knapsack,items,knapsack[items.length][capacity]);
    return result;
  }

  private static List<List<Integer>> getKnapSackValues(int[][] knapsack, int[][] items, int maxWeight) {
    List<List<Integer>> sequence = new ArrayList<>();
    List<Integer> totalWeight = new ArrayList<>();
    totalWeight.add(maxWeight);
    sequence.add(totalWeight);
    sequence.add(new ArrayList<>());
    // we will start back track it from end
    int i = knapsack.length-1;
    int c = knapsack[0].length-1;
    while (i>0){
      if(knapsack[i][c]==knapsack[i-1][c]){
        i--;
      }else {
        // i is the row is the items index
        sequence.get(1).add(0,i-1);
        c= c- items[i-1][1];
        i--;
      }
      if (c==0)
        break;
    }
    return sequence;
  }
}
