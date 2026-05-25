package com.ankur.interview.practice.graphs;

public class GraphValidTree {

    // Algorithm: Union-Find (Disjoint Set Union)
    //
    // A graph is a valid tree if and only if two conditions hold:
    //   1. It has exactly n-1 edges  →  fewer means disconnected, more guarantees a cycle
    //   2. It has no cycle           →  detected by Union-Find: if two nodes share a root
    //                                    before being unioned, they're already connected
    //
    // Together these conditions guarantee the graph is connected and acyclic (i.e. a tree).
    // Time: O(n · α(n))  |  Space: O(n)
    public boolean isGraphValidTree(int n, int[][] edges) {
        // Condition 1: a tree on n nodes always has exactly n-1 edges
        if (edges.length != n - 1) return false;

        // Each node starts as its own component (self-referencing parent)
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);
            // Condition 2: if both endpoints share a root, adding this edge creates a cycle
            if (rootA == rootB) return false;
            // Merge the two components
            parent[rootA] = rootB;
        }

        return true;
    }

    // Path-halving find: flattens the tree by skipping every other node toward the root,
    // keeping future lookups near O(1) without a full path-compression pass.
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // skip one level up
            x = parent[x];
        }
        return x;
    }
}