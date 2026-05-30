package com.ankur.interview.practice.graphs;

import java.util.Arrays;

public class BellmanFord {

    // Returns shortest distances from `start` to all vertices.
    // -1 means unreachable; Integer.MIN_VALUE means the vertex is on or
    // downstream of a negative-weight cycle (distance is unboundedly negative).
    //
    // edges[u] = [[v, weight], ...] — same format as Dijkstra in this package.
    // Unlike Dijkstra, handles negative edge weights and detects negative cycles.
    // Time: O(V * E)   Space: O(V)
    public static int[] bellmanFord(int start, int[][][] edges) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // After k passes, dist[v] holds the shortest path from `start` using
        // at most k edges. A cycle-free path visits at most n vertices, so it
        // uses at most n-1 edges — n-1 passes always converge on a valid graph.
        for (int pass = 0; pass < n - 1; pass++) {
            for (int u = 0; u < n; u++) {
                if (dist[u] == Integer.MAX_VALUE) continue; // u not yet reached
                for (int[] edge : edges[u]) {
                    int v = edge[0], w = edge[1];
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        // If a distance still improves on the nth pass, a path of n edges
        // exists — meaning some vertex is visited twice, i.e. there is a
        // negative-weight cycle reachable from `start` on that path.
        boolean[] inNegCycle = new boolean[n];
        for (int u = 0; u < n; u++) {
            if (dist[u] == Integer.MAX_VALUE) continue;
            for (int[] edge : edges[u]) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v] || inNegCycle[u]) {
                    inNegCycle[v] = true;
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) result[i] = -1;               // unreachable
            else if (inNegCycle[i])           result[i] = Integer.MIN_VALUE; // negative cycle
            else                              result[i] = dist[i];
        }
        return result;
    }
}