package com.ankur.interview.practice.dynamicprogramming;

public class CoinChange {
    public static void main(String[] args) {
        int[]a={1,2,5};
        int total =12;
        int numberofWays=getCoinCombinations(a,total);
        System.out.println(numberofWays);
    }

    private static int getCoinCombinations(int[] coins, int total) {
        int[] combinations = new int[total+1];
        combinations[0]=1;
        for (int coin: coins) {
            for(int amount =1;amount<combinations.length;amount++){
               if(amount>=coin){
                   combinations[amount]=combinations[amount]+combinations[amount-coin];
               }
            }
        }
        return combinations[combinations.length-1];
    }

}
