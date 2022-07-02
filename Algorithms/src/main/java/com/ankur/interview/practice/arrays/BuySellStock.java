package com.ankur.interview.practice.arrays;

public class BuySellStock {


    public static int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            hold = Math.max(hold, sell - prices[i]);
            sell = Math.max(sell, hold + prices[i]);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] a= {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
