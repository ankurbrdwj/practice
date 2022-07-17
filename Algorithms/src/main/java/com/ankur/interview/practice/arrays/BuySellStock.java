package com.ankur.interview.practice.arrays;

public class BuySellStock {
/*One-Pass

Notice that the maximum profit that can be made by selling on a specific day is determined by the minimum of the stock prices over the previous days. Thus, we can loop over each price in prices, and keep updating the minimum price and at the same update the maximum profit.

Note: The ordering of updating maxProfit and minPrice does not matter.
/
 */

    public static int maxProfit(int[] prices) {
      int maxProfit = 0;
      int minPrice = Integer.MAX_VALUE;
      for (int price : prices) {
          maxProfit = Math.max(maxProfit, price - minPrice);
          minPrice = Math.min(minPrice, price);
        }
      return maxProfit;
    }

    public static void main(String[] args) {
        int[] a= {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
