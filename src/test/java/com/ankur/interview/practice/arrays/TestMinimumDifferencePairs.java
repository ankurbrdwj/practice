package com.ankur.interview.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestMinimumDifferencePairs {
    @Test
    public void testSample() {
        List<Integer> latencies = List.of(6, 4, 2, 10);
        List<List<Integer>> pairs = MinimumDifferencePairs.findMinDifferencePairs(latencies, 4);

        assertEquals(2, pairs.size());
        assertEquals(List.of(2, 4), pairs.get(0));
        assertEquals(List.of(4, 6), pairs.get(1));
    }
}