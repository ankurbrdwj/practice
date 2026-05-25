package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class TestTopKFrequent {

    // helper: order of result doesn't matter, so sort both before comparing
    private void assertTopK(int[] expected, int[] actual) {
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoDistinctFrequencies_returnsTopK() {
        // nums = [1,1,1,2,2,3], k = 2
        // freq map:  {1:3, 2:2, 3:1}
        // buckets:   [3]->[1]  [2]->[2]  [1]->[3]
        // scan right→left: bucket[3]=[1], bucket[2]=[2] → collected k=2, stop
        // expected: [1, 2]
        int[] result = TopKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertTopK(new int[]{1, 2}, result);
    }

    @Test
    public void twoManySameFreq_returnsTopK() {
        // nums = [1,1,1,2,2,3,4,4,6,5,5], k = 2
        // freq map:  {1:3, 2:2, 3:1, 4:2, 5:2, 6:1}
        //
        // bucket[3] = TreeSet{1}          ← only 1 has freq=3
        // bucket[2] = [2, 4, 5]  ← 2,4,5 all tie at freq=2; order depends on HashMap iteration
        // bucket[1] = [3, 6]
        //
        // scan right → left:
        //   i=3: take 1          → result: [1]
        //   i=2: take first tie  → result: [1, ?]  ← any of {2,4,5}, idx==k stop
        //
        // assertTopK sorts before comparing so any tie winner is accepted
        // expected: [1] must be present; second element is one of the tied group {2,4,5}
        int[] result = TopKFrequent.topKFrequent(new int[]{1,1,1,2,2,3,4,4,6,5,5}, 2);
        assertEquals(1, result[0] == 1 ? result[0] : result[1]); // 1 must be in result
        assertTrue(result[0] == 2 || result[0] == 4 || result[0] == 5
                || result[1] == 2 || result[1] == 4 || result[1] == 5); // tie winner in result
    }

    @Test
    public void singleElement_returnsItself() {
        // nums = [1], k = 1
        // freq map: {1:1}
        // buckets:  [1]->[1]
        // scan: bucket[1]=[1] → collected k=1
        // expected: [1]
        int[] result = TopKFrequent.topKFrequent(new int[]{1}, 1);
        assertTopK(new int[]{1}, result);
    }

    @Test
    public void allSameElement_returnsIt() {
        // nums = [5,5,5,5], k = 1
        // freq map: {5:4}
        // buckets:  [4]->[5]
        // scan: bucket[4]=[5] → collected k=1
        // expected: [5]
        int[] result = TopKFrequent.topKFrequent(new int[]{5, 5, 5, 5}, 1);
        assertTopK(new int[]{5}, result);
    }

    @Test
    public void kEqualsDistinctCount_returnsAll() {
        // nums = [1,2,3], k = 3  (all appear once, all must be returned)
        // freq map: {1:1, 2:1, 3:1}
        // buckets:  [1]->[1,2,3]
        // scan: bucket[1] fills all k=3 slots
        // expected: [1, 2, 3]
        int[] result = TopKFrequent.topKFrequent(new int[]{1, 2, 3}, 3);
        assertTopK(new int[]{1, 2, 3}, result);
    }

    @Test
    public void negativeNumbers_handledCorrectly() {
        // nums = [-1,-1,2], k = 1
        // freq map: {-1:2, 2:1}
        // buckets:  [2]->[-1]  [1]->[2]
        // scan: bucket[2]=[-1] → collected k=1, stop
        // expected: [-1]
        int[] result = TopKFrequent.topKFrequent(new int[]{-1, -1, 2}, 1);
        assertTopK(new int[]{-1}, result);
    }
}