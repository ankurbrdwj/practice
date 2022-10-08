package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.MaxProfitWithKTransactions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMaxProfitWithKTransactions {
  @Test
  public void testMaxProfit(){
    int k=3;
    int [] prices = new int[]{2,5,7,1,4,3,1,3};
    Assertions.assertTrue(MaxProfitWithKTransactions.maxProfit(prices,k) == 10);

  }
}
