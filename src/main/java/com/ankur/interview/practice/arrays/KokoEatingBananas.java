package com.ankur.interview.practice.arrays;

import java.util.Arrays;

/*
 * Koko Eating Bananas (LeetCode 875) — Binary Search on Answer Space
 *
 * Find the minimum eating speed k (bananas/hour) such that Koko can eat
 * all piles within h hours. Each hour she eats at most k bananas from one pile.
 *
 * Search space: [1, max(piles)].
 * For a given speed, hours needed = sum of ceil(pile/speed).
 * Binary search for the smallest speed where hoursNeeded <= h.
 *
 * Time  O(n log maxPile)
 * Space O(1)
 *
 * Example: piles=[3,6,7,11], h=8 → 4
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hoursNeeded(piles, mid) <= h) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private long hoursNeeded(int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles) hours += (pile + speed - 1) / speed;
        return hours;
    }
}