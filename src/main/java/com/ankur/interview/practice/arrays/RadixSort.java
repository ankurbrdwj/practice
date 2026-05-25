package com.ankur.interview.practice.arrays;

public class RadixSort {

    // Algorithm: Radix Sort (LSD — Least Significant Digit first)
    //
    // Core idea: instead of comparing whole numbers, sort digit-by-digit starting
    // from the rightmost digit (1s), then 10s, then 100s, etc.
    // After all digit passes the array is fully sorted.
    //
    // *** Is it O(n)? ***
    //   Time:  O(d × n)  where d = number of digits in the largest number.
    //   For a fixed upper bound on values (e.g. 32-bit ints, d ≤ 10), d is a constant,
    //   so it reduces to O(n).  But if values grow with n (e.g. n numbers up to n²),
    //   then d = O(log n) and the true cost is O(n log n) — same as comparison sorts.
    //   Space: O(n + k)  where k = base (10 here), for the counting-sort buckets.
    //
    // *** Radix Sort vs Bucket Sort (TopKFrequent) ***
    //   Bucket sort there was O(n) because the key (frequency) was BOUNDED by n —
    //   index == value, so no passes needed.
    //   Radix sort processes digits one pass at a time; each pass is O(n) but you need
    //   d passes.  Use radix sort when you want a fully sorted array of arbitrary integers.
    //   Use bucket sort when the key fits a bounded integer range you can index directly.
    //
    // ═══════════════════════════════════════════════════════════════
    // FULL TRACE — input: [53, 4, 312, 7]     max = 312 → 3 passes
    // ═══════════════════════════════════════════════════════════════
    //
    // ── PASS 1: exp=1 (sort by 1s digit) ──────────────────────────
    //
    //   Each number's 1s digit:
    //     53 → 3      4 → 4      312 → 2      7 → 7
    //
    //   Step A — count how many numbers have each digit:
    //     digit:   0  1  2  3  4  5  6  7  8  9
    //     count:  [0, 0, 1, 1, 1, 0, 0, 1, 0, 0]
    //                    ↑  ↑  ↑        ↑
    //                   312 53  4        7
    //
    //   Step B — prefix-sum: count[d] becomes "how many numbers have digit ≤ d"
    //            This tells us the last output slot (exclusive) for each digit group.
    //     digit:   0  1  2  3  4  5  6  7  8  9
    //     count:  [0, 0, 1, 2, 3, 3, 3, 4, 4, 4]
    //             so digit-2 numbers fill slot [0..0], digit-3 fills [1..1], etc.
    //
    //   Step C — fill output RIGHT-TO-LEFT (right-to-left preserves relative order):
    //     i=3: nums[3]=7,   digit=7, slot=count[7]-1=3, output[3]=7,   count[7]=3
    //     i=2: nums[2]=312, digit=2, slot=count[2]-1=0, output[0]=312, count[2]=0
    //     i=1: nums[1]=4,   digit=4, slot=count[4]-1=2, output[2]=4,   count[4]=2
    //     i=0: nums[0]=53,  digit=3, slot=count[3]-1=1, output[1]=53,  count[3]=1
    //
    //   After pass 1: [312, 53, 4, 7]
    //   ✓ sorted by 1s digit: ...2  ...3  ...4  ...7
    //
    // ── PASS 2: exp=10 (sort by 10s digit) ────────────────────────
    //
    //   Input: [312, 53, 4, 7]
    //   Each number's 10s digit:
    //     312 → 1      53 → 5      4 → 0      7 → 0
    //
    //   Step A — count:
    //     digit:   0  1  2  3  4  5  6  7  8  9
    //     count:  [2, 1, 0, 0, 0, 1, 0, 0, 0, 0]
    //              ↑  ↑           ↑
    //             4,7 312         53
    //
    //   Step B — prefix-sum:
    //     count:  [2, 3, 3, 3, 3, 4, 4, 4, 4, 4]
    //
    //   Step C — fill right-to-left:
    //     i=3: nums[3]=7,   digit=0, slot=1, output[1]=7,   count[0]=1
    //     i=2: nums[2]=4,   digit=0, slot=0, output[0]=4,   count[0]=0
    //     i=1: nums[1]=53,  digit=5, slot=3, output[3]=53,  count[5]=3
    //     i=0: nums[0]=312, digit=1, slot=2, output[2]=312, count[1]=2
    //
    //   After pass 2: [4, 7, 312, 53]
    //   ✓ sorted by 10s digit: 0_  0_  1__  5_
    //     Note: 4 and 7 both have 10s digit 0 — their relative order (4 before 7)
    //     is preserved from pass 1, which is WHY we fill right-to-left (stability).
    //
    // ── PASS 3: exp=100 (sort by 100s digit) ──────────────────────
    //
    //   Input: [4, 7, 312, 53]
    //   Each number's 100s digit:
    //     4 → 0      7 → 0      312 → 3      53 → 0
    //
    //   Step A — count:
    //     digit:   0  1  2  3  4  5  6  7  8  9
    //     count:  [3, 0, 0, 1, 0, 0, 0, 0, 0, 0]
    //              ↑           ↑
    //            4,7,53       312
    //
    //   Step B — prefix-sum:
    //     count:  [3, 3, 3, 4, 4, 4, 4, 4, 4, 4]
    //
    //   Step C — fill right-to-left:
    //     i=3: nums[3]=53,  digit=0, slot=2, output[2]=53,  count[0]=2
    //     i=2: nums[2]=312, digit=3, slot=3, output[3]=312, count[3]=3
    //     i=1: nums[1]=7,   digit=0, slot=1, output[1]=7,   count[0]=1
    //     i=0: nums[0]=4,   digit=0, slot=0, output[0]=4,   count[0]=0
    //
    //   After pass 3: [4, 7, 53, 312]  ✓ FULLY SORTED
    //
    public static int[] sort(int[] nums) {
        if (nums.length <= 1) return nums;

        int max = findMax(nums);

        // One stable counting-sort pass per digit position
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(nums, exp);
        }

        return nums;
    }

    // Stable counting sort on the digit at position exp (1=units, 10=tens, ...).
    // Stability is critical: numbers with the same digit must keep the relative
    // order they earned in previous passes, otherwise earlier passes are wasted.
    private static void countingSortByDigit(int[] nums, int exp) {
        int n = nums.length;
        int[] output = new int[n];
        int[] count = new int[10]; // slots for digits 0-9

        // Step A: count occurrences of each digit at this position
        for (int num : nums) count[(num / exp) % 10]++;

        // Step B: prefix-sum — count[d] now = number of elements with digit ≤ d
        // = the exclusive upper bound of digit d's block in the output array
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        // Step C: place elements right-to-left to keep the sort stable
        // --count[digit] gives the next free slot for that digit, filling from right
        for (int i = n - 1; i >= 0; i--) {
            int digit = (nums[i] / exp) % 10;
            output[--count[digit]] = nums[i];
        }

        System.arraycopy(output, 0, nums, 0, n);
    }

    private static int findMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) if (num > max) max = num;
        return max;
    }
}