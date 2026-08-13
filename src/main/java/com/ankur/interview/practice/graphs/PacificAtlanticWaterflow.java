package com.ankur.interview.practice.graphs;

import java.util.*;

/*
 * PROBLEM: Pacific Atlantic Water Flow (LeetCode 417) — DFS from boundaries
 *
 * Given an m×n grid of heights, rain water flows from a cell to a neighbor
 * only if the neighbor's height is <= the current cell (water flows downhill
 * or stays level). Water at the top/left border drains to the Pacific ocean;
 * water at the bottom/right border drains to the Atlantic ocean.
 *
 * Return all cells from which water can flow to BOTH oceans.
 *
 * Insight — flip the direction:
 *   Instead of asking "can water at (r,c) reach the ocean?", ask
 *   "which cells can be reached FROM the ocean boundary going uphill?"
 *   This lets us start DFS at the border and expand inward, moving only to
 *   cells with height >= current (reverse of water flow direction).
 *
 * Algorithm:
 *   1. Run DFS from every Pacific border cell  → mark reachable set P.
 *   2. Run DFS from every Atlantic border cell → mark reachable set A.
 *   3. Return cells in P ∩ A.
 *
 * Time  O(m × n) — each cell visited at most twice (once per ocean DFS)
 * Space O(m × n) — two boolean grids + recursion stack
 *
 * Example:
 *   heights = [[1,2,2,3,5],
 *              [3,2,3,4,4],
 *              [2,4,5,3,1],
 *              [6,7,1,4,5],
 *              [5,1,1,2,4]]
 *   → [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 */
public class PacificAtlanticWaterflow {

    private int[][] heights;
    private int rows, cols;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific  = new boolean[rows][cols]; // cells that can reach Pacific
        boolean[][] atlantic = new boolean[rows][cols]; // cells that can reach Atlantic

        // Pacific touches the top row and left column
        for (int r = 0; r < rows; r++) dfs(r, 0,        pacific);
        for (int c = 0; c < cols; c++) dfs(0, c,        pacific);

        // Atlantic touches the bottom row and right column
        for (int r = 0; r < rows; r++) dfs(r, cols - 1, atlantic);
        for (int c = 0; c < cols; c++) dfs(rows - 1, c, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c])    // reachable by both oceans
                    result.add(Arrays.asList(r, c));
            }
        }
        return result;
    }

    // DFS expanding uphill from the ocean boundary inward.
    // visited[r][c] = true means this cell can drain to the corresponding ocean.
    private void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue; // out of bounds
            if (visited[nr][nc]) continue;                               // already marked
            if (heights[nr][nc] < heights[r][c]) continue;              // can't flow uphill
            dfs(nr, nc, visited);
        }
    }
}