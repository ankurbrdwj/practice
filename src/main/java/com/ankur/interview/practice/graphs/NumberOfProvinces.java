package com.ankur.interview.practice.graphs;

import edu.princeton.cs.algorithms.UF;

/*
 * PROBLEM: Number of Provinces (LeetCode 547)
 *
 * There are n cities. You are given an n x n adjacency MATRIX `isConnected`
 * where isConnected[i][j] = 1 means city i and city j are directly connected,
 * and 0 means they are not. A "province" is a group of cities that are directly
 * or indirectly connected. Return the total number of provinces.
 *
 * vs. Number of Islands:
 *   - Islands:   implicit graph, input is a 2D grid of chars, DFS flood-fill
 *   - Provinces: explicit graph, input is an adjacency matrix, Union-Find
 *   Both problems count connected components — only the graph representation differs.
 *
 * Approach: Union-Find (Disjoint Set)
 *   For every edge (i,j) in the matrix, union cities i and j into the same set.
 *   UF tracks how many disjoint sets remain — that's the province count.
 *
 * Time  O(n²·α(n)) ≈ O(n²)  — must read every cell; α is near-constant (inverse Ackermann)
 * Space O(n)                 — UF internal arrays
 *
 * Example:
 *   isConnected = [[1,1,0],   city 0 and 1 are connected
 *                  [1,1,0],   city 1 and 0 are connected (symmetric)
 *                  [0,0,1]]   city 2 is on its own
 *   → 2 provinces: {0,1} and {2}
 */
public class NumberOfProvinces {

  public int findCircleNum(int[][] isConnected) {
    int N = isConnected.length;        // number of cities = number of rows (square matrix)
    UF uf = new UF(N);                 // start with N disjoint sets, one per city

    for (int i = 0; i < isConnected.length; i++) {        // for each city i
      for (int j = 0; j < isConnected[i].length; j++) {   // check its relationship with every city j
        if (isConnected[i][j] == 1) {  // direct connection exists between i and j
          uf.union(i, j);              // merge their sets; if already in same set, count stays same
        }
      }
    }

    return uf.count();                 // number of disjoint sets remaining = number of provinces
  }
}
