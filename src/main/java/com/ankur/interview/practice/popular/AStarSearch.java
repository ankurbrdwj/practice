package com.ankur.interview.practice.popular;

import java.util.*;

// A* on a 2D grid. 0 = open cell, 1 = wall.
// Returns the shortest path as a list of [row, col] pairs, or empty list if no path.
// f(n) = g(n) + h(n)  where h = Manhattan distance to goal.
public class AStarSearch {

    public static List<int[]> findPath(int[][] grid, int[] start, int[] end) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] gScore = new int[rows][cols];
        for (int[] row : gScore) Arrays.fill(row, Integer.MAX_VALUE);
        gScore[start[0]][start[1]] = 0;

        // priority queue ordered by f = g + h
        PriorityQueue<int[]> open = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[2])
        );
        open.offer(new int[]{start[0], start[1], heuristic(start, end)});

        int[][] cameFrom = new int[rows * cols][2];
        for (int[] row : cameFrom) Arrays.fill(row, -1);

        boolean[][] visited = new boolean[rows][cols];

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!open.isEmpty()) {
            int[] current = open.poll();
            int r = current[0], c = current[1];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (r == end[0] && c == end[1]) return reconstruct(cameFrom, start, end, cols);

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] == 1 || visited[nr][nc]) continue;

                int tentativeG = gScore[r][c] + 1;
                if (tentativeG < gScore[nr][nc]) {
                    gScore[nr][nc] = tentativeG;
                    cameFrom[nr * cols + nc][0] = r;
                    cameFrom[nr * cols + nc][1] = c;
                    open.offer(new int[]{nr, nc, tentativeG + heuristic(new int[]{nr, nc}, end)});
                }
            }
        }
        return Collections.emptyList();
    }

    private static int heuristic(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private static List<int[]> reconstruct(int[][] cameFrom, int[] start, int[] end, int cols) {
        LinkedList<int[]> path = new LinkedList<>();
        int r = end[0], c = end[1];
        while (r != start[0] || c != start[1]) {
            path.addFirst(new int[]{r, c});
            int[] prev = cameFrom[r * cols + c];
            r = prev[0];
            c = prev[1];
        }
        path.addFirst(new int[]{start[0], start[1]});
        return path;
    }
}