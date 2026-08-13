package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestPacificAtlantic {

    private final PacificAtlanticWaterflow solution = new PacificAtlanticWaterflow();

    private Set<String> toSet(List<List<Integer>> cells) {
        Set<String> s = new HashSet<>();
        for (List<Integer> c : cells) s.add(c.get(0) + "," + c.get(1));
        return s;
    }

    // LeetCode example — 7 cells reach both oceans
    @Test
    public void testLeetcodeExample() {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        Set<String> expected = new HashSet<>(Arrays.asList(
            "0,4","1,3","1,4","2,2","3,0","3,1","4,0"
        ));
        assertEquals(expected, toSet(solution.pacificAtlantic(heights)));
    }

    // 1×1 grid — the single cell borders both oceans
    @Test
    public void testSingleCell() {
        List<List<Integer>> result = solution.pacificAtlantic(new int[][]{{5}});
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(0, 0), result.get(0));
    }

    // Flat grid — all cells reach both oceans (water flows freely at same height)
    @Test
    public void testFlatGrid_allCellsReachBoth() {
        int[][] heights = {{1,1},{1,1}};
        assertEquals(4, solution.pacificAtlantic(heights).size());
    }

    // Increasing heights left-to-right, top-to-bottom:
    // only the bottom-right corner cell can reach Atlantic;
    // only the top-left corner can trivially reach Pacific.
    // The top row can reach Pacific; the right column can reach Atlantic.
    @Test
    public void testStrictlyIncreasing() {
        int[][] heights = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        // Right column and bottom row border Atlantic; top row and left column border Pacific.
        // All cells can reach Pacific (water flows left/up to Pacific border).
        // Only cells in the bottom row or right column (or both) reach Atlantic directly or via downhill.
        // With strictly increasing grid, bottom-right area reaches Atlantic.
        Set<String> result = toSet(solution.pacificAtlantic(heights));
        assertTrue(result.contains("0,2")); // top-right: borders both
        assertTrue(result.contains("2,0")); // bottom-left: borders both
        assertTrue(result.contains("2,2")); // bottom-right: borders both
    }
}