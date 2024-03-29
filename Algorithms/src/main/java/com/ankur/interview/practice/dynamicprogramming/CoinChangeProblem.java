package com.ankur.interview.practice.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeProblem {


    public int minCoinTopDown(int[] coins, int total, Map<Integer, Integer> map) {

        //if total is 0 then there is nothing to do. return 0.
        if (total == 0) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if (map.containsKey(total)) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //if value of coin is greater than total we are looking for just continue.
            if (coins[i] > total) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minCoinTopDown(coins, total - coins[i], map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if (val < min) {
                min = val;
            }
        }
        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
        min = (min == Integer.MAX_VALUE ? min : min + 1);

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }

  /*  public int minCoinBottomUp(int total, int coins[]) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }
        for (int coin = 0; coin < coins.length; coin++) {
            for (int amount = 1; amount <= total; amount++) {
                if (amount >= coins[coin]) {
                    if (T[amount - coins[coin]] + 1 < T[amount]) {
                        T[amount] = 1 + T[amount - coins[coin]];
                        R[amount] = coin;
                    }
                }
            }
        }
        //printCoinCombination(R, coins);
        return T[total]==Integer.MAX_VALUE - 1?-1:T[total];
    }*/

    private void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while (start != 0) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

    public int minCoinBottomUp(int total, int coins[]) {
        int T[][] = new int[coins.length][total + 1];
        for (int i = 0; i < coins.length; i++) {
            T[i][0] = 0;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                T[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        //first row
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= coins[i]) {
                    if (T[i][j - coins[i]] + 1 < T[i][j]) {
                        T[i][j] = 1 + T[i][j - coins[i]];
                    }
                }
            }
        }
        // rest rows
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= coins[i]) {
                    T[i][j] = Math.min(T[i][j - coins[i]] + 1, T[i - 1][j]);
                }else{
                    T[i][j] =T[i - 1][j];
                }
            }
        }
        return T[coins.length-1][total] == Integer.MAX_VALUE - 1 ? -1 : T[coins.length-1][total];
    }


    public static void main(String args[]) {
        int total = 10;
        int coins[] = {2, 3, 5};
        CoinChangeProblem cc = new CoinChangeProblem();
        Map<Integer, Integer> map = new HashMap<>();
        //int topDownValue = cc.minCoinTopDown(coins, total, map);
        int bottomUpValue = cc.minCoinBottomUp(total, coins);

        System.out.print(String.format("Bottom up and top down result %s", bottomUpValue));

    }
}
