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

  static int buySellStockInfiniteTransaction(int[] prices) {
    int left = 0;
    int right = 0;
    // right is sell
    int profit = 0;
    while (right < prices.length - 1) {
      // if the prices are increasing
      if (prices[right + 1] >= prices[right]) {
        right++;
      } else {
        if (left < right) {
          profit = profit + prices[right] - prices[left];
        }
        right++;
        left = right;
      }
    }
    // if array keeps increasing till last
    profit = profit + prices[right] - prices[left];
    return profit;
  }

  static int buySellStockTwoTransaction(int[] prices) {
    // traverse left to right
    int minSoFar = prices[0];
    int maxTillNow = 0;
    int[] maxNowSellToday = new int[prices.length];
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (minSoFar > prices[i]) {
        minSoFar = prices[i];
      }
      maxTillNow = prices[i] - minSoFar;
      if (maxTillNow > maxNowSellToday[i - 1]) {
        maxNowSellToday[i] = maxTillNow;
      } else {
        maxNowSellToday[i] = maxNowSellToday[i - 1];
      }
    }
    int maxIfBuyNow = 0;
    int[] maxNowBuyToday = new int[prices.length];
    for (int i = prices.length - 2; i > 0; i--) {
      if (maxIfBuyNow > prices[i]) {
        maxIfBuyNow = prices[i];
      }
      maxTillNow = prices[i] - minSoFar;
      if (maxTillNow > maxNowBuyToday[i - 1]) {
        maxNowSellToday[i] = maxTillNow;
      } else {
        maxNowSellToday[i] = maxNowSellToday[i - 1];
      }
    }
    // if array keeps increasing till last
    return profit;
  }

  public static void main(String[] args) {
    // Exchange rates for euro and DOLLAR FOR DIFFERENT DAYS
    // find max profit after buying and selling one time within the date range
    int[] rates = new int[]{1, 2, 3, 4, 5};

    System.out.println(buySellStockInfiniteTransaction(rates));

  }
}
