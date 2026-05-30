package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBellmanFord {

    // ── helpers ──────────────────────────────────────────────────────────────

    private static void assertDistances(int[] result, int[] expected) {
        Assertions.assertArrayEquals(expected, result);
    }

    // ── tests ─────────────────────────────────────────────────────────────────

    // Same graph as TestDijkstra — Bellman-Ford must agree when all weights > 0.
    //
    //  0 -7-> 1 -6-> 2 -14-> 3
    //          |              ^
    //         20             2
    //          |              |
    //          +-----3----> 4
    //  5 (disconnected)
    @Test
    public void testPositiveWeights() {
        int[][][] edges = {
            {{1, 7}},
            {{2, 6}, {3, 20}, {4, 3}},
            {{3, 14}},
            {{4, 2}},
            {},
            {}
        };
        assertDistances(
            BellmanFord.bellmanFord(0, edges),
            new int[]{0, 7, 13, 27, 10, -1}
        );
    }

    // Negative edges — Dijkstra would give wrong answers here.
    //
    //  0 -1-> 1 -(-5)-> 2 -2-> 3
    //  0 -10-> 3
    //
    // Shortest to 2: 0->1->2 = 1 + (-5) = -4
    // Shortest to 3: 0->1->2->3 = -4 + 2 = -2  (not the direct 0->3 = 10)
    @Test
    public void testNegativeEdges() {
        int[][][] edges = {
            {{1, 1}, {3, 10}},
            {{2, -5}},
            {{3, 2}},
            {}
        };
        assertDistances(
            BellmanFord.bellmanFord(0, edges),
            new int[]{0, 1, -4, -2}
        );
    }

    // Negative cycle: 1 -> 2 -> 3 -> 1 has total weight -1.
    // Vertices on or downstream of the cycle get Integer.MIN_VALUE.
    //
    //  0 -1-> 1
    //  1 -2-> 2
    //  2 -1-> 3 (-4)-> 1   (cycle weight: 2+1-4 = -1)
    //  3 -5-> 4            (4 is downstream of the cycle)
    @Test
    public void testNegativeCycleDetected() {
        int[][][] edges = {
            {{1, 1}},
            {{2, 2}},
            {{3, 1}},
            {{1, -4}, {4, 5}},
            {}
        };
        int[] result = BellmanFord.bellmanFord(0, edges);
        Assertions.assertEquals(0,                 result[0]); // source
        Assertions.assertEquals(Integer.MIN_VALUE, result[1]); // in cycle
        Assertions.assertEquals(Integer.MIN_VALUE, result[2]); // in cycle
        Assertions.assertEquals(Integer.MIN_VALUE, result[3]); // in cycle
        Assertions.assertEquals(Integer.MIN_VALUE, result[4]); // downstream of cycle
    }

    // Disconnected graph — unreachable vertices return -1.
    @Test
    public void testDisconnectedGraph() {
        int[][][] edges = {
            {{1, 5}},
            {},
            {{3, 3}}, // component unreachable from 0
            {}
        };
        assertDistances(
            BellmanFord.bellmanFord(0, edges),
            new int[]{0, 5, -1, -1}
        );
    }

    // Single node with no edges.
    @Test
    public void testSingleNode() {
        int[][][] edges = {{}};
        assertDistances(
            BellmanFord.bellmanFord(0, edges),
            new int[]{0}
        );
    }

    // Start from a non-zero source.
    //
    //  0 <-3- 2 -4-> 1
    //  start = 2: dist to 0 = 3, dist to 1 = 4
    @Test
    public void testNonZeroSource() {
        int[][][] edges = {
            {},
            {},
            {{0, 3}, {1, 4}}
        };
        assertDistances(
            BellmanFord.bellmanFord(2, edges),
            new int[]{3, 4, 0}
        );
    }
}