package com.ankur.interview.practice.dynamicprogramming;

public class BuySellStock {
  // brute force - buy  one day and sell on all other days and get the max O(n2)  -- O(n)
  // lowest buy and highest sell  lowest and highest
  /*
  / The trick to this question is keep traking the minimu
   */
  static double getMaxProfit(double[] rates) {
    double maxRate = Double.MIN_VALUE;
    double minBuy = 0;
    double maxSell = 0;
    // array is always forward moving so take the 0th and start form 1 for fist difference
    double currentMin = rates[0];
    for (int i = 1; i < rates.length; i++) {
      if (currentMin > rates[i]) {
        currentMin = rates[i];
      }// if we are already a min number
      else {
        maxRate = Math.max(maxRate, rates[i] - currentMin);
      }
    }
    return maxRate;
  }

  static double buySellStockOneSlidingWindow(double[] rates) {
    int left = 0;
    int right = 1;
    // right is sell
    double profit;
    double maxProfit = 0;
    while (right < rates.length) {
      // do we have profit
      if (rates[right] > rates[left]) {
        profit = rates[right] - rates[left];
        maxProfit = Math.max(maxProfit, profit);
      } else {
        // all in between don't matter, new low matters
        left = right;
      }
      right++;
    }
    return maxProfit;
  }


  public static void main(String[] args) {
    // Exchange rates for euro and DOLLAR FOR DIFFERENT DAYS
    // find max profit after buying and selling one time within the date range
    double[] rates = new double[]{0.91, 0.93, 0.92, 0.94, 0.95, 0.96, 0.90, 0.93};

    System.out.println(buySellStockOneSlidingWindow(rates));

  }
}
