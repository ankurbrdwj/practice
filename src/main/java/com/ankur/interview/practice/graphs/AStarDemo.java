package com.ankur.interview.practice.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Runnable demo for A* pathfinding on three sample grids.
//
// ─── SAMPLE RUN OUTPUT ──────────────────────────────────────────────────────
//
// === Example 1: Straight shot — heuristic keeps A* on the top row ===
//
// Grid:
//  S  .  .  G
//  .  #  .  .
//  .  .  .  .
//
// Path (cost 3): (0,0) → (0,1) → (0,2) → (0,3)
//
// Path on grid:
//  S  *  *  G
//  .  #  .  .
//  .  .  .  .
//
// ────────────────────────────────────────────────────────────────────────────
//
// === Example 2: Walls block top row — A* detours through middle ===
//
// Grid:
//  S  #  #  G
//  .  .  .  .
//  .  .  .  .
//
// Path (cost 5): (0,0) → (1,0) → (1,1) → (1,2) → (1,3) → (0,3)
//
// Path on grid:
//  S  #  #  G
//  *  *  *  *
//  .  .  .  .
//
// ────────────────────────────────────────────────────────────────────────────
//
// === Example 3: Goal completely walled off — no path ===
//
// Grid:
//  S  .  .  .
//  .  .  #  .
//  .  #  G  #
//  .  .  #  .
//
// No path found.
//
// ────────────────────────────────────────────────────────────────────────────
public class AStarDemo {

    public static void main(String[] args) {

        // ── Example 1: open corridor ─────────────────────────────────────────
        // Wall at (1,1) is irrelevant — A* stays on row 0 the whole time
        // because the heuristic (Manhattan distance) steers it straight right.
        int[][] grid1 = {
            {0, 0, 0, 0},  // row 0:  S  .  .  G
            {0, 1, 0, 0},  // row 1:  .  #  .  .
            {0, 0, 0, 0}   // row 2:  .  .  .  .
        };
        run("Example 1: Straight shot — heuristic keeps A* on the top row",
            grid1, new Point(0, 0), new Point(0, 3));

        // ── Example 2: top row blocked ───────────────────────────────────────
        // A* can't go right from start; it drops to row 1, traverses right,
        // then climbs back up — shortest detour the heuristic can find.
        int[][] grid2 = {
            {0, 1, 1, 0},  // row 0:  S  #  #  G
            {0, 0, 0, 0},  // row 1:  .  .  .  .
            {0, 0, 0, 0}   // row 2:  .  .  .  .
        };
        run("Example 2: Walls block top row — A* detours through middle",
            grid2, new Point(0, 0), new Point(0, 3));

        // ── Example 3: goal surrounded by walls ──────────────────────────────
        // All four neighbours of (2,2) are walls; no path can reach it.
        int[][] grid3 = {
            {0, 0, 0, 0},  // row 0:  S  .  .  .
            {0, 0, 1, 0},  // row 1:  .  .  #  .
            {0, 1, 0, 1},  // row 2:  .  #  G  #   ← G is fully enclosed
            {0, 0, 1, 0}   // row 3:  .  .  #  .
        };
        run("Example 3: Goal completely walled off — no path",
            grid3, new Point(0, 0), new Point(2, 2));
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    private static void run(String title, int[][] grid, Point start, Point goal) {
        System.out.println("=== " + title + " ===\n");
        System.out.println("Grid:");
        printGrid(grid, start, goal, null);
        System.out.println();

        List<Point> path = AStar.findPath(grid, start, goal);

        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Path (cost " + (path.size() - 1) + "): " + format(path));
            System.out.println("\nPath on grid:");
            printGrid(grid, start, goal, path);
        }

        System.out.println("\n" + "─".repeat(76) + "\n");
    }

    // Renders the grid using single characters; overlays path as '*'.
    // Start and Goal always show as S/G regardless of path membership.
    private static void printGrid(int[][] grid, Point start, Point goal, List<Point> path) {
        Set<Point> onPath = path == null ? new HashSet<>() : new HashSet<>(path);
        for (int r = 0; r < grid.length; r++) {
            StringBuilder row = new StringBuilder();
            for (int c = 0; c < grid[0].length; c++) {
                Point p = new Point(r, c);
                String cell;
                if      (p.equals(start))      cell = " S";
                else if (p.equals(goal))       cell = " G";
                else if (grid[r][c] == 1)      cell = " #";
                else if (onPath.contains(p))   cell = " *";
                else                           cell = " .";
                row.append(cell);
            }
            System.out.println(row);
        }
    }

    private static String format(List<Point> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(" → ");
            sb.append(path.get(i));
        }
        return sb.toString();
    }
}