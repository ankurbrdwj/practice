package com.ankur.interview.practice.graphs;

/*
 * Number of Islands (LeetCode 200) — DFS Flood Fill
 *
 * Count connected components of '1's in a grid.
 * For each unvisited '1', run DFS to mark the entire island as visited
 * by overwriting cells with '0' (in-place). Increment counter per DFS start.
 *
 * Time  O(m * n)
 * Space O(m * n) worst-case recursion stack (entire grid is one island)
 *
 * Example:
 *   grid = [["1","1","0"],
 *           ["0","1","0"],
 *           ["0","0","1"]]  → 2
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') return;
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}