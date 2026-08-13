package com.ankur.interview.practice.graphs;

import java.util.*;

// A* (A-Star) — informed shortest-path search for 2-D grids.
//
// HOW IT DIFFERS FROM DIJKSTRA & BFS
// ─────────────────────────────────────────────────────────────────────────────
//   BFS       : explores by hop count          f = 1  (unweighted, blind)
//   Dijkstra  : explores by real cost so far   f = g  (weighted, blind)
//   A*        : explores by real + estimated   f = g + h  (weighted, guided)
//
//   g(n) = exact cost paid to reach n from start
//   h(n) = heuristic estimate of remaining cost to goal  (must never over-estimate)
//   f(n) = g + h  →  the priority queue is sorted by f
//
// The heuristic is what gives A* its "GPS" power — it biases expansion toward
// the goal so far fewer nodes are ever visited than Dijkstra would touch.
//
// HEURISTIC USED HERE: Manhattan distance  |Δrow| + |Δcol|
//   • Admissible  : never over-estimates on a 4-directional grid (each step
//                   moves exactly 1 unit toward or away from the goal).
//   • Consistent  : h(n) ≤ cost(n→n') + h(n')  →  we never re-expand a node,
//                   so the closed-set skip is safe.
//
// =========================================================================
// EXAMPLE TRACE — 3×4 Grid, Wall at (1,1)
// =========================================================================
//
//   Grid layout (S=start, G=goal, #=wall, .=open):
//
//     col →   0     1     2     3
//   row 0  [  S  ][  .  ][  .  ][  G  ]
//   row 1  [  .  ][  #  ][  .  ][  .  ]
//   row 2  [  .  ][  .  ][  .  ][  .  ]
//
//   Start = (0,0)    Goal = (0,3)    h = Manhattan distance to (0,3)
//
//   ── Open heap notation:  Point  g  h  f ──────────────────────────────────
//
//   Initial:
//     open  = [ (0,0) g=0 h=3 f=3 ]
//     bestG = { (0,0):0 }
//
//   ── Step 1  pop (0,0) f=3 ────────────────────────────────────────────────
//     Expand neighbours (4 directions, walls & OOB skipped):
//       → (0,1)  g=1  h= |0-0|+|1-3| =2   f=3   pushed ✓
//       ↓ (1,0)  g=1  h= |1-0|+|0-3| =4   f=5   pushed ✓
//
//     open  = [ (0,1) f=3,  (1,0) f=5 ]
//     bestG = { (0,0):0,  (0,1):1,  (1,0):1 }
//
//   ── Step 2  pop (0,1) f=3 ────────────────────────────────────────────────
//     Expand neighbours:
//       ← (0,0)  newG=2 > bestG 0,  skip
//       → (0,2)  g=2  h= |0-0|+|2-3| =1   f=3   pushed ✓
//       ↓ (1,1)  = wall, skip
//
//     open  = [ (0,2) f=3,  (1,0) f=5 ]
//     bestG = { ...,  (0,2):2 }
//
//   ── Step 3  pop (0,2) f=3 ────────────────────────────────────────────────
//     Expand neighbours:
//       ← (0,1)  newG=3 > bestG 1,  skip
//       → (0,3)  g=3  h= 0          f=3   pushed ✓  ← GOAL IN QUEUE
//       ↓ (1,2)  g=3  h= |1-0|+|2-3| =2  f=5   pushed ✓
//
//     open  = [ (0,3) f=3,  (1,0) f=5,  (1,2) f=5 ]
//
//   ── Step 4  pop (0,3) f=3  →  GOAL REACHED! ──────────────────────────────
//
//   Path reconstruction (follow parent pointers back to start):
//     (0,3) ← (0,2) ← (0,1) ← (0,0)
//     result = [ (0,0), (0,1), (0,2), (0,3) ]   total cost = 3
//
//   KEY INSIGHT: A* never touched row 1 or row 2 — the heuristic kept the
//   search glued to the top row, heading straight for the goal.
//   Dijkstra would have expanded (1,0) and beyond before finding this path.
//
// =========================================================================
public class AStar {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Internal search node: tracks cost, heuristic, and parent for path reconstruction.
    private static class Node implements Comparable<Node> {
        final Point point;
        final int   g;      // cost from start to this node
        final int   h;      // heuristic estimate to goal
        final Node  parent; // to reconstruct path once goal is found

        Node(Point point, int g, int h, Node parent) {
            this.point  = point;
            this.g      = g;
            this.h      = h;
            this.parent = parent;
        }

        int f() { return g + h; }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.f(), other.f());
        }
    }

    // Manhattan distance — admissible & consistent for 4-directional grids.
    private static int heuristic(Point a, Point b) {
        return Math.abs(a.row - b.row) + Math.abs(a.col - b.col);
    }

    // Returns the shortest path from start to goal on grid, or an empty list
    // if no path exists.
    //
    // grid[r][c] = 0 → open cell
    // grid[r][c] = 1 → wall (impassable)
    public static List<Point> findPath(int[][] grid, Point start, Point goal) {
        int rows = grid.length, cols = grid[0].length;

        // Min-heap ordered by f = g + h
        PriorityQueue<Node> open = new PriorityQueue<>();
        // bestG tracks the lowest g-cost we've found for each Point so far.
        // If we pop a node whose g exceeds bestG, a better path already exists — skip it.
        Map<Point, Integer> bestG = new HashMap<>();

        open.add(new Node(start, 0, heuristic(start, goal), null));
        bestG.put(start, 0);

        while (!open.isEmpty()) {
            Node current = open.poll();

            if (current.point.equals(goal)) {
                return reconstructPath(current);
            }

            // A stale entry: a cheaper path to this point was already processed.
            if (current.g > bestG.getOrDefault(current.point, Integer.MAX_VALUE)) continue;

            for (int[] dir : DIRS) {
                int nr = current.point.row + dir[0];
                int nc = current.point.col + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] == 1) continue; // wall

                Point neighbor = new Point(nr, nc);
                int newG = current.g + 1;

                if (newG < bestG.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    bestG.put(neighbor, newG);
                    open.add(new Node(neighbor, newG, heuristic(neighbor, goal), current));
                }
            }
        }

        return Collections.emptyList(); // no path exists
    }

    // Walks the parent chain from goal back to start, then reverses to get
    // the forward path.
    private static List<Point> reconstructPath(Node node) {
        LinkedList<Point> path = new LinkedList<>();
        while (node != null) {
            path.addFirst(node.point);
            node = node.parent;
        }
        return path;
    }
}