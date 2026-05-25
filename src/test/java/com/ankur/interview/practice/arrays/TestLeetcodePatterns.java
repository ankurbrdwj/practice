package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for LeetCode pattern problems:
 * ContainWater, SearchRotatedArray, ProductOfArrayExceptItself,
 * MaximumProductSubarray, MoveZeros, MaxAverageSubarray,
 * KokoEatingBananas, ShipPackages, PivotIndex, SubarraySumEqualsK, RangeSumQuery
 */
class TestLeetcodePatterns {

    // ── ContainWater ─────────────────────────────────────────────────────────
    @Test void containWater_basic() {
        assertEquals(49, new ContainWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    @Test void containWater_twoElements() {
        assertEquals(1, new ContainWater().maxArea(new int[]{1,1}));
    }

    // ── SearchRotatedArray ───────────────────────────────────────────────────
    @Test void searchRotated_targetPresent() {
        assertEquals(4, new SearchRotatedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    @Test void searchRotated_targetAbsent() {
        assertEquals(-1, new SearchRotatedArray().search(new int[]{4,5,6,7,0,1,2}, 3));
    }
    @Test void searchRotated_singleElement() {
        assertEquals(-1, new SearchRotatedArray().search(new int[]{1}, 0));
    }
    @Test void findMin_rotated() {
        assertEquals(0, new SearchRotatedArray().findMin(new int[]{4,5,6,7,0,1,2}));
    }
    @Test void findMin_notRotated() {
        assertEquals(1, new SearchRotatedArray().findMin(new int[]{1,3,5}));
    }

    // ── ProductOfArrayExceptItself ───────────────────────────────────────────
    @Test void productExceptSelf_basic() {
        assertArrayEquals(new int[]{24,12,8,6},
            new ProductOfArrayExceptItself().productExceptSelf(new int[]{1,2,3,4}));
    }
    @Test void productExceptSelf_withZero() {
        assertArrayEquals(new int[]{0,0,9,0,0},
            new ProductOfArrayExceptItself().productExceptSelf(new int[]{-1,1,0,-3,3}));
    }

    // ── MaximumProductSubarray ───────────────────────────────────────────────
    @Test void maxProduct_basic() {
        assertEquals(6, new MaximumProductSubarray().maxProduct(new int[]{2,3,-2,4}));
    }
    @Test void maxProduct_withZero() {
        assertEquals(0, new MaximumProductSubarray().maxProduct(new int[]{-2,0,-1}));
    }
    @Test void maxProduct_allNegatives() {
        // best subarray is [-3,-4]=12; full product -24 is not max
        assertEquals(12, new MaximumProductSubarray().maxProduct(new int[]{-2,-3,-4}));
    }

    // ── MoveZeros ────────────────────────────────────────────────────────────
    @Test void moveZeroes_basic() {
        int[] nums = {0,1,0,3,12};
        new MoveZeros().moveZeroes(nums);
        assertArrayEquals(new int[]{1,3,12,0,0}, nums);
    }
    @Test void moveZeroes_noZeros() {
        int[] nums = {1,2,3};
        new MoveZeros().moveZeroes(nums);
        assertArrayEquals(new int[]{1,2,3}, nums);
    }

    // ── MaxAverageSubarray ───────────────────────────────────────────────────
    @Test void maxAverage_basic() {
        assertEquals(12.75,
            new MaxAverageSubarray().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4), 1e-9);
    }

    // ── KokoEatingBananas ────────────────────────────────────────────────────
    @Test void koko_basic() {
        assertEquals(4, new KokoEatingBananas().minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
    @Test void koko_large() {
        assertEquals(30, new KokoEatingBananas().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }

    // ── ShipPackages ─────────────────────────────────────────────────────────
    @Test void ship_basic() {
        assertEquals(15,
            new ShipPackages().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
    @Test void ship_oneDayEach() {
        assertEquals(3,
            new ShipPackages().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

    // ── PivotIndex ───────────────────────────────────────────────────────────
    @Test void pivotIndex_found() {
        assertEquals(3, new PivotIndex().pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    @Test void pivotIndex_notFound() {
        assertEquals(-1, new PivotIndex().pivotIndex(new int[]{1,2,3}));
    }
    @Test void pivotIndex_atStart() {
        assertEquals(0, new PivotIndex().pivotIndex(new int[]{0,0,0}));
    }

    // ── SubarraySumEqualsK ───────────────────────────────────────────────────
    @Test void subarraySum_basic() {
        assertEquals(2, new SubarraySumEqualsK().subarraySum(new int[]{1,1,1}, 2));
    }
    @Test void subarraySum_multiple() {
        assertEquals(2, new SubarraySumEqualsK().subarraySum(new int[]{1,2,3}, 3));
    }

    // ── RangeSumQuery ────────────────────────────────────────────────────────
    @Test void rangeSum_queries() {
        RangeSumQuery rsq = new RangeSumQuery(new int[]{-2,0,3,-5,2,-1});
        assertEquals(1,  rsq.sumRange(0, 2));
        assertEquals(-1, rsq.sumRange(2, 5));
        assertEquals(-3, rsq.sumRange(0, 5));
    }
}