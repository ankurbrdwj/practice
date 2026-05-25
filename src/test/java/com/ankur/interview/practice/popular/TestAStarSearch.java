package com.ankur.interview.practice.popular;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestAStarSearch {

    @Test
    public void findsShortestPathInOpenGrid() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        List<int[]> path = AStarSearch.findPath(grid, new int[]{0, 0}, new int[]{2, 2});
        Assertions.assertFalse(path.isEmpty());
        Assertions.assertArrayEquals(new int[]{0, 0}, path.get(0));
        Assertions.assertArrayEquals(new int[]{2, 2}, path.get(path.size() - 1));
        Assertions.assertEquals(5, path.size()); // Manhattan distance = 4, so 5 cells
    }

    @Test
    public void routesAroundWall() {
        int[][] grid = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        List<int[]> path = AStarSearch.findPath(grid, new int[]{0, 0}, new int[]{0, 2});
        Assertions.assertFalse(path.isEmpty());
        Assertions.assertArrayEquals(new int[]{0, 0}, path.get(0));
        Assertions.assertArrayEquals(new int[]{0, 2}, path.get(path.size() - 1));
    }

    @Test
    public void returnsEmptyWhenBlocked() {
        int[][] grid = {
            {0, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        List<int[]> path = AStarSearch.findPath(grid, new int[]{0, 0}, new int[]{0, 2});
        Assertions.assertTrue(path.isEmpty());
    }

    @Test
    public void startEqualsEnd() {
        int[][] grid = {{0, 0}, {0, 0}};
        List<int[]> path = AStarSearch.findPath(grid, new int[]{1, 1}, new int[]{1, 1});
        Assertions.assertEquals(1, path.size());
        Assertions.assertArrayEquals(new int[]{1, 1}, path.get(0));
    }
}