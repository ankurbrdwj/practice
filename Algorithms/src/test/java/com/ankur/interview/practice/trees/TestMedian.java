package com.ankur.interview.practice.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMedian {
/*
/{
  "classMethodsToCall": [
    {"arguments": [5], "method": "insert"},
    {"arguments": [10], "method": "insert"},
    {"arguments": [100], "method": "insert"},
    {"arguments": [], "method": "getMedian"},
    {"arguments": [200], "method": "insert"},
    {"arguments": [], "method": "getMedian"}
  ]
}
 */
    @Test
    public void TestCase1() {
        Median.ContinuousMedianHandler handler = new Median.ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        handler.insert(100);
        Assertions.assertTrue(handler.getMedian() == 10);
        handler.insert(200);
        Assertions.assertTrue(handler.getMedian() == 55);
    }
}

