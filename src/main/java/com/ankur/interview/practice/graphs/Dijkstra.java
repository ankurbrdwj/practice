package com.ankur.interview.practice.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Dijkstra's Algorithm — Single-Source Shortest Path
//
// Problem: Given a weighted directed graph and a start node, find the shortest
// distance from `start` to every other node. Edge weights must be non-negative.
// Returns -1 for nodes that are unreachable from `start`.
//
// Input:  start      — index of the source node
//         edges      — adjacency list: edges[u] = [[v, weight], ...] for each u
// Output: int[]      — shortest distance from start to each node (index = node id)
//
// Example:
//   edges = [
//     [[1,4],[2,1]],   // node 0 → node1(cost4), node2(cost1)
//     [[3,1]],         // node 1 → node3(cost1)
//     [[1,2],[3,5]],   // node 2 → node1(cost2), node3(cost5)
//     []               // node 3 → no outgoing edges
//   ]
//   dijkstra(0, edges) → [0, 3, 1, 4]
//   // 0→0=0, 0→2→1=3, 0→2=1, 0→2→1→3=4
//
// Approach — "greedy expand cheapest unvisited node":
//   1. Init all distances to ∞, set dist[start]=0.
//   2. Repeatedly pick the unvisited node with the smallest known distance (extractMin).
//   3. For each of its neighbors, relax the edge: if going through the current node
//      is cheaper, update the neighbor's distance.
//   4. Mark the node visited — its distance is now final (greedy guarantee).
//   5. Stop when all nodes are visited or the next cheapest is unreachable (∞).
//
// Time:  O(V²) — extractMin is a linear scan; use a min-heap to get O((V+E) log V)
// Space: O(V)
public class Dijkstra {

    public static  int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.
        int noOfVertices = edges.length;
        int[] minDistances = new int[edges.length]; // array for min distances
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[start] = 0;

        Set<Integer> visited = new HashSet<>();
        // extract min and relax
        while (visited.size() != noOfVertices) {
            // every time get min and move from there
            int[] minVertex = extractMin(minDistances, visited);
            int vertex = minVertex[0];
            int currentMinDistance = minVertex[1];
            if (currentMinDistance == Integer.MAX_VALUE) {
                break; // there is no path to this vertex
            }
            visited.add(vertex);
            for (int[] edge : edges[vertex]) {
                int dest = edge[0];
                int distance = edge[1];
                if (visited.contains(dest)) {
                    continue;
                }
                // indexes are vertex so this loop is always  sorted
                int newDistance = currentMinDistance + distance;
                int currentDistance = minDistances[dest];
                // Edge relaxation: is path through current vertex cheaper?
                if (newDistance < currentDistance) {
                    minDistances[dest] = newDistance;
                }
            }
        }
        int[] finalDistances = new int[minDistances.length];
        for (int i = 0; i < minDistances.length; i++) {
            int d = minDistances[i];
            finalDistances[i] = d == Integer.MAX_VALUE ? -1 : d; // -1 means unreachable
        }
        return finalDistances;
    }

    // Linear scan over all unvisited nodes to find the one with the smallest distance.
    // This is the bottleneck: O(V) per call → O(V²) total. A min-heap reduces this to O(log V).
    private static int[] extractMin(int[] minDistances, Set<Integer> visited) {
        int currentMin = Integer.MAX_VALUE;
        int vertex = -1;
        for (int vid = 0; vid < minDistances.length; vid++) {
            int distance = minDistances[vid];
            if (visited.contains(vid)) { // we wont look at it if visited
                continue;
            }
            if (distance <= currentMin) { // get minimum
                vertex = vid;
                currentMin = distance;
            }
        }
        return new int[]{vertex, currentMin};
    }
}
