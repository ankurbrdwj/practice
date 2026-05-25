package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for: NumberOfIslands, CourseSchedule, LongestConsecutiveSequence, WordLadder
 */
class TestLeetcodeGraphPatterns {

    // ── NumberOfIslands ──────────────────────────────────────────────────────
    @Test void islands_one() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, new NumberOfIslands().numIslands(grid));
    }
    @Test void islands_three() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals(3, new NumberOfIslands().numIslands(grid));
    }

    // ── CourseSchedule ───────────────────────────────────────────────────────
    @Test void courseSchedule_canFinish() {
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{1,0}}));
    }
    @Test void courseSchedule_cycle() {
        assertFalse(new CourseSchedule().canFinish(2, new int[][]{{1,0},{0,1}}));
    }
    @Test void courseSchedule_noPrereqs() {
        assertTrue(new CourseSchedule().canFinish(3, new int[][]{}));
    }

    // ── LongestConsecutiveSequence ───────────────────────────────────────────
    @Test void consecutive_basic() {
        assertEquals(4, new LongestConsecutiveSequence().longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    @Test void consecutive_withDuplicates() {
        assertEquals(9, new LongestConsecutiveSequence().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    @Test void consecutive_empty() {
        assertEquals(0, new LongestConsecutiveSequence().longestConsecutive(new int[]{}));
    }

    // ── WordLadder ───────────────────────────────────────────────────────────
    @Test void wordLadder_basic() {
        assertEquals(5, new WordLadder().ladderLength(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log","cog")
        ));
    }
    @Test void wordLadder_noPath() {
        assertEquals(0, new WordLadder().ladderLength(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log")
        ));
    }
}