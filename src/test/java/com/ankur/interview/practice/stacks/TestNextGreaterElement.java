package com.ankur.interview.practice.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestNextGreaterElement {

    private final NextGreaterElement nge = new NextGreaterElement();

    // ── non-circular: [4, 5, 2, 10, 8] ──────────────────────────────────────
    //   4 → 5, 5 → 10, 2 → 10, 10 → -1, 8 → -1

    @Test
    void bruteForce_basic() {
        assertArrayEquals(
            new int[]{5, 10, 10, -1, -1},
            nge.bruteForce(new int[]{4, 5, 2, 10, 8})
        );
    }

    @Test
    void optimal_rightToLeft_basic() {
        assertArrayEquals(
            new int[]{5, 10, 10, -1, -1},
            nge.optimal(new int[]{4, 5, 2, 10, 8})
        );
    }

    @Test
    void optimal_leftToRight_basic() {
        assertArrayEquals(
            new int[]{5, 10, 10, -1, -1},
            nge.optimalLeftToRight(new int[]{4, 5, 2, 10, 8})
        );
    }

    @Test
    void allThree_produceIdenticalResults() {
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6};
        assertArrayEquals(nge.bruteForce(input), nge.optimal(input));
        assertArrayEquals(nge.bruteForce(input), nge.optimalLeftToRight(input));
    }

    // ── non-circular edge cases ───────────────────────────────────────────────

    @Test
    void descendingArray_allMinusOne() {
        assertArrayEquals(
            new int[]{-1, -1, -1},
            nge.optimal(new int[]{9, 5, 1})
        );
    }

    @Test
    void ascendingArray_eachPointsToNext() {
        assertArrayEquals(
            new int[]{2, 3, 4, -1},
            nge.optimal(new int[]{1, 2, 3, 4})
        );
    }

    @Test
    void singleElement() {
        assertArrayEquals(new int[]{-1}, nge.optimal(new int[]{7}));
    }

    // ── circular variant ─────────────────────────────────────────────────────
    //   [2, 5, -3, -4, 6, 7, 2] → [5, 6, 6, 6, 7, -1, 5]
    //   note: 2 at index 6 wraps around and finds 5 at index 1

    @Test
    void circular_wrapsAround() {
        assertArrayEquals(
            new int[]{5, 6, 6, 6, 7, -1, 5},
            nge.circular(new int[]{2, 5, -3, -4, 6, 7, 2})
        );
    }

    @Test
    void circular_maxElementStaysMinusOne() {
        // 7 is the global max; no element in the entire circle is greater
        int[] input = {2, 5, -3, -4, 6, 7, 2};
        assertEquals(-1, nge.circular(input)[5]);
    }

    @Test
    void circular_singleElement() {
        assertArrayEquals(new int[]{-1}, nge.circular(new int[]{42}));
    }
}