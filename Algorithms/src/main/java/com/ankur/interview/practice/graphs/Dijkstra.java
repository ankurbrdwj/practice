package com.ankur.interview.practice.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
            // ervery time get min and move from there
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
                // if this is minimium
                if (newDistance < currentDistance) {
                    minDistances[dest] = newDistance;
                }
            }
        }
        int[] finalDistances = new int[minDistances.length];
        for (int i = 0; i < minDistances.length; i++) {
            int d = minDistances[i];
            finalDistances[i] = d == Integer.MAX_VALUE ? -1 : d;
        }
        return finalDistances;
    }

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
