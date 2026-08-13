package com.ankur.interview.practice.graphs;

import java.util.*;

// A* on a 2-D integer grid — AlgoExpert-style signature.
// Returns the path as int[][row,col] pairs from start to end,
// or int[][]{} when no path exists.
//
// graph[r][c] = 0 → open cell     graph[r][c] = 1 → wall
//
// ─── WHY A Node WRAPPER INSTEAD OF PriorityQueue<Point> ────────────────────
//
//   A common mistake is writing:
//     PriorityQueue<Point> pq = new PriorityQueue<>(
//         Comparator.comparingInt(p -> gCost[p.row][p.col] + h(p)));
//
//   This reads gCost LIVE from the array. When we later update gCost[r][c]
//   to a cheaper value and re-insert the Point, both the old and new entries
//   sit in the heap — but the comparator now sees the UPDATED (lower) cost
//   for the old entry too, silently corrupting heap order.
//
//   Fix: freeze f = g + h at insertion time inside a Node.
//   Stale entries are harmless — we skip them with a visited[][] check.
//
// ─── DATA STRUCTURES ────────────────────────────────────────────────────────
//
//   gCost[r][c]  — best actual cost from start to (r,c) found so far
//   parent[r][c] — Point we came from (for path reconstruction)
//   visited[r][c]— true once a node is popped and processed
//                  (with Manhattan — a consistent heuristic — the first pop
//                   is always optimal, so we never need to re-process)
//
// ─── EXAMPLE TRACE  start=(0,0)  end=(0,3) ──────────────────────────────────
//
//   Grid:                         h = Manhattan to (0,3)
//    row 0  [ S ][ . ][ . ][ G ]
//    row 1  [ . ][ # ][ . ][ . ]
//    row 2  [ . ][ . ][ . ][ . ]
//
//   Push (0,0) f=0+3=3
//
//   Pop (0,0) f=3  expand:
//     (0,1) g=1 h=2 f=3  pushed    parent[(0,1)]=(0,0)
//     (1,0) g=1 h=4 f=5  pushed    parent[(1,0)]=(0,0)
//
//   Pop (0,1) f=3  expand:
//     (0,0) visited, skip
//     (0,2) g=2 h=1 f=3  pushed    parent[(0,2)]=(0,1)
//     (1,1) = wall, skip
//
//   Pop (0,2) f=3  expand:
//     (0,3) g=3 h=0 f=3  pushed ← GOAL   parent[(0,3)]=(0,2)
//     (1,2) g=3 h=2 f=5  pushed
//
//   Pop (0,3) f=3  → GOAL, reconstruct:
//     (0,3) ← parent (0,2) ← parent (0,1) ← parent (0,0)
//     path = [ [0,0], [0,1], [0,2], [0,3] ]
//
//   (1,0) and (1,2) were pushed but never popped — A* never left row 0.
// ─────────────────────────────────────────────────────────────────────────────
public class AStarAlgorithm {

    // Freezes f at insertion time so the heap's order is never corrupted
    // by later updates to gCost[][].
    private static class Node {
        final Point point;
        final int   f; // g + h, fixed when this Node was created

        Node(Point point, int f) {
            this.point = point;
            this.f     = f;
        }
    }

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] aStarAlgorithm(
            int startRow, int startCol, int endRow, int endCol, int[][] graph) {

        int rows = graph.length, cols = graph[0].length;

        int[][] gCost = new int[rows][cols];
        for (int[] row : gCost) Arrays.fill(row, Integer.MAX_VALUE);
        gCost[startRow][startCol] = 0;

        // Point at each cell we came from; null at start (sentinel for path end).
        Point[][] parent = new Point[rows][cols];

        boolean[][] visited = new boolean[rows][cols];

        // Min-heap on frozen f values.
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        pq.offer(new Node(new Point(startRow, startCol),
                          manhattan(startRow, startCol, endRow, endCol)));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            Point p   = curr.point;

            // Stale entry: a cheaper path to p was processed after this Node
            // was pushed. The frozen f is now outdated — skip it.
            if (visited[p.row][p.col]) continue;
            visited[p.row][p.col] = true;

            if (p.row == endRow && p.col == endCol) {
                return buildPath(parent, startRow, startCol, endRow, endCol);
            }

            for (int[] dir : DIRS) {
                int nr = p.row + dir[0];
                int nc = p.col + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (graph[nr][nc] == 1 || visited[nr][nc]) continue;

                int newG = gCost[p.row][p.col] + 1;
                if (newG < gCost[nr][nc]) {
                    gCost[nr][nc]  = newG;
                    parent[nr][nc] = p; // arrived at (nr,nc) from Point p
                    int f = newG + manhattan(nr, nc, endRow, endCol);
                    pq.offer(new Node(new Point(nr, nc), f));
                }
            }
        }

        return new int[][] {}; // no path exists
    }

    // Walks parent pointers from end back to start, then reverses.
    // parent[startRow][startCol] is null — that's the loop's stop condition.
    private int[][] buildPath(
            Point[][] parent, int startRow, int startCol, int endRow, int endCol) {

        LinkedList<int[]> path = new LinkedList<>();
        int r = endRow, c = endCol;
        while (parent[r][c] != null) {
            path.addFirst(new int[]{r, c});
            Point prev = parent[r][c];
            r = prev.row;
            c = prev.col;
        }
        path.addFirst(new int[]{r, c}); // start cell (parent is null)
        return path.toArray(new int[0][]);
    }

    private static int manhattan(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    // =========================================================================
    // VARIANT — A* with no POJO / Point class
    // =========================================================================
    //
    // Replaces Point with a flat index:  idx = row * cols + col
    //   decode row  →  idx / cols
    //   decode col  →  idx % cols
    //
    // Replaces Node wrapper with int[] = {row, col, f} in the PQ.
    // Replaces Point[][] parent with int[] parent (flat index of the cell
    // we came from).  -1 = no parent (start node).
    //
    // Everything else — gCost, visited, rebalance, stale-skip — is identical.
    // Use this form when you want zero object allocation beyond int arrays.
    //
    // ── SAME TRACE  start=(0,0)  end=(0,3)  cols=4 ──────────────────────────
    //
    //   flat indices:
    //     (0,0)=0  (0,1)=1  (0,2)=2  (0,3)=3
    //     (1,0)=4  (1,1)=5  (1,2)=6  (1,3)=7
    //
    //   Push [r=0,c=0,f=3]
    //   Pop  [0,0,3]  idx=0  expand:
    //     [0,1,3] pushed  parent[1]=0
    //     [1,0,5] pushed  parent[4]=0
    //   Pop  [0,1,3]  idx=1  expand:
    //     [0,2,3] pushed  parent[2]=1
    //     (1,1)=wall skip
    //   Pop  [0,2,3]  idx=2  expand:
    //     [0,3,3] pushed  parent[3]=2  ← GOAL
    //   Pop  [0,3,3]  idx=3  → goal!
    //   Reconstruct: 3 → parent[3]=2 → parent[2]=1 → parent[1]=0 (start)
    //   path = [ [0,0],[0,1],[0,2],[0,3] ]
    // =========================================================================
    public int[][] aStarNoPojo(
            int startRow, int startCol, int endRow, int endCol, int[][] graph) {

        int rows  = graph.length;
        int cols  = graph[0].length;
        int total = rows * cols;

        int[] gCost = new int[total];
        Arrays.fill(gCost, Integer.MAX_VALUE);
        gCost[startRow * cols + startCol] = 0;

        // parent[idx] = flat index of the cell we came from; -1 = start (no parent)
        int[] parent = new int[total];
        Arrays.fill(parent, -1);

        boolean[] visited = new boolean[total];

        // int[] = { row, col, f }  — f frozen at push time (same reason as above)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{startRow, startCol,
                           manhattan(startRow, startCol, endRow, endCol)});

        // Keep going as long as there are reachable cells left to explore.
        while (!pq.isEmpty()) {

            // Pop the cell with the lowest f = g + h (most promising next step).
            int[] curr = pq.poll();

            // Unpack row and col from the int[] entry {row, col, f}.
            int r = curr[0], c = curr[1];

            // Convert 2-D position to a flat index so we can use 1-D arrays.
            int flatIdx = r * cols + c;

            // This entry was pushed when a worse g was the best we knew.
            // A cheaper path arrived later and already processed this cell — skip.
            if (visited[flatIdx]) continue;

            // Lock this cell: first pop with a consistent heuristic is always optimal.
            visited[flatIdx] = true;

            // Reached the goal — trace parent pointers back to build the path.
            if (r == endRow && c == endCol) {
                return buildPathFlat(parent, cols, startRow, startCol, endRow, endCol);
            }

            // Try all 4 neighbours (up, down, left, right).
            for (int[] dir : DIRS) {

                // Candidate neighbour position.
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Skip if out of grid bounds.
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                // Skip walls.
                if (graph[nr][nc] == 1) continue;

                // Flat index for the neighbour.
                int neighbourFlatIdx = nr * cols + nc;

                // Already processed with its optimal cost — no point revisiting.
                if (visited[neighbourFlatIdx]) continue;

                // Each step costs 1, so g of neighbour = g of current + 1.
                int newG = gCost[flatIdx] + 1;

                // YES — this is exactly where the direction can change.
                //
                // gCost[neighbourFlatIdx] starts at Integer.MAX_VALUE (never visited).
                // newG is always < MAX_VALUE on first arrival, so we set the
                // initial route.  But later, a *different* path through a
                // different cell might reach the same neighbour cheaper.
                // When that happens newG < gCost[neighbourFlatIdx] is true again and we
                // overwrite parent[neighbourFlatIdx] — effectively re-routing through the
                // better direction.
                //
                // Example — reaching (1,2) from two directions:
                //
                //   first  arrival via (1,1): newG=3  gCost[neighbourFlatIdx]=∞  → set parent=(1,1) ✓
                //   second arrival via (0,2): newG=2  gCost[neighbourFlatIdx]=3  → re-route parent=(0,2) ✓
                //   third  arrival via (1,3): newG=4  gCost[neighbourFlatIdx]=2  → ignored (4 > 2) ✗
                //
                // The cell we end up in result traces back through whichever
                // direction produced the smallest g — that's the shortest path.
                if (newG < gCost[neighbourFlatIdx]) {

                    // Record the new best cost to reach neighbour.
                    gCost[neighbourFlatIdx] = newG;

                    // Overwrite the parent — we came from a better direction now.
                    parent[neighbourFlatIdx] = flatIdx;

                    // f = g + h: freeze it now so the heap order stays stable.
                    int f = newG + manhattan(nr, nc, endRow, endCol);

                    // Push neighbour with its frozen f; old entry (if any) becomes stale.
                    pq.offer(new int[]{nr, nc, f});
                }
            }
        }

        return new int[][] {}; // no path
    }

    // Walks the flat parent chain from end back to start.
    //
    // FLAT INDEX CONCEPT
    // ──────────────────────────────────────────────────────────────────────
    // A 2-D grid is stored in memory as one long 1-D array, row by row:
    //
    //   grid (3 rows × 4 cols):        flat array indices:
    //   ┌────┬────┬────┬────┐          ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
    //   │0,0 │0,1 │0,2 │0,3 │          │ 0 │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │10 │11│
    //   ├────┼────┼────┼────┤          └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘
    //   │1,0 │1,1 │1,2 │1,3 │           row 0 ──────────  row 1 ──────────  row 2 ──────
    //   ├────┼────┼────┼────┤
    //   │2,0 │2,1 │2,2 │2,3 │
    //   └────┴────┴────┴────┘
    //
    // ENCODE  (row, col)  →  flat index:
    //   idx = row * cols + col
    //   e.g. (1, 2) → 1 * 4 + 2 = 6  ✓
    //
    // DECODE  flat index  →  (row, col):
    //   row = idx / cols      (integer division → how many full rows fit)
    //   col = idx % cols      (remainder → position within that row)
    //   e.g. idx=6 → row=6/4=1, col=6%4=2 → (1,2)  ✓
    //
    // WHY DO THIS?  So parent[], gCost[], visited[] can all be plain int[]
    // and boolean[] instead of int[][] and boolean[][] — one index instead
    // of two, and no inner-array allocation per row.
    // ──────────────────────────────────────────────────────────────────────
    private int[][] buildPathFlat(
            int[] parent, int cols,
            int startRow, int startCol, int endRow, int endCol) {

        LinkedList<int[]> path = new LinkedList<>();

        // Encode the goal cell into its flat index to start walking backwards.
        int idx      = endRow * cols + endCol;
        int startIdx = startRow * cols + startCol;

        while (idx != startIdx) {
            // Decode flat index back to (row, col) to build the int[][row,col] result.
            path.addFirst(new int[]{idx / cols, idx % cols});
            // Follow the parent pointer to the previous cell on the path.
            idx = parent[idx];
        }
        path.addFirst(new int[]{startRow, startCol});
        return path.toArray(new int[0][]);
    }
}