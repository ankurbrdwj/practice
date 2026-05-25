package com.ankur.interview.practice.arrays;

import java.util.Arrays;

/*
 * Capacity to Ship Packages Within D Days (LeetCode 1011) — Binary Search on Answer Space
 *
 * Find minimum ship weight capacity to load all packages in `days` days,
 * keeping package order. Each day load as many consecutive packages as fit.
 *
 * Search space: [max(weights), sum(weights)].
 *   lo = max weight (must fit the heaviest single package)
 *   hi = total weight (ship everything in one day)
 * Binary search for the smallest capacity where canShip is true.
 *
 * Time  O(n log(sum - max))
 * Space O(1)
 *
 * Example: weights=[1,2,3,4,5,6,7,8,9,10], days=5 → 15
 */
public class ShipPackages {

    public int shipWithinDays(int[] weights, int days) {
        int lo = Arrays.stream(weights).max().getAsInt();
        int hi = Arrays.stream(weights).sum();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, days, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int daysNeeded = 1, current = 0;
        for (int w : weights) {
            if (current + w > cap) { daysNeeded++; current = 0; }
            current += w;
        }
        return daysNeeded <= days;
    }
}