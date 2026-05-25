package com.ankur.interview.practice.heaps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for: LastStoneWeight, KthLargestElement, TopKFrequentElements
 */
class TestLeetcodeHeapPatterns {

    // ── LastStoneWeight ──────────────────────────────────────────────────────
    @Test void lastStone_basic() {
        assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
    @Test void lastStone_allDestroyed() {
        assertEquals(0, new LastStoneWeight().lastStoneWeight(new int[]{1,1}));
    }
    @Test void lastStone_single() {
        assertEquals(5, new LastStoneWeight().lastStoneWeight(new int[]{5}));
    }

    // ── KthLargestElement ────────────────────────────────────────────────────
    @Test void kthLargest_basic() {
        assertEquals(5, new KthLargestElement().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
    @Test void kthLargest_duplicates() {
        assertEquals(4, new KthLargestElement().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    // ── TopKFrequentElements ─────────────────────────────────────────────────
    @Test void topKFrequent_basic() {
        int[] result = new TopKFrequentElements().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1,2}, result);
    }
    @Test void topKFrequent_single() {
        assertArrayEquals(new int[]{1},
            new TopKFrequentElements().topKFrequent(new int[]{1}, 1));
    }
    @Test void topKFrequent_buckets_basic() {
        int[] result = new TopKFrequentElements().topKFrequentBuckets(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1,2}, result);
    }
}