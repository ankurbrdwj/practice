package com.ankur.interview.practice.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumIslandsChar {

  // Method to count the number of islands in the given grid
  public static int numIslands(char[][] grid) {
    // Create a visited boolean matrix to track the cells we've already explored
    boolean[][] visited = new boolean[grid.length][];

    // Initialize the visited matrix with false values
    for (int i = 0; i < grid.length; i++) {
      visited[i] = new boolean[grid[i].length];
      for (int j = 0; j < grid[i].length; j++) {
        visited[i][j] = false; // No cell is visited at the beginning
      }
    }

    // List to store the sizes of each island (for debugging or other purposes)
    List<Integer> sizes = new ArrayList<>();

    // Traverse every cell in the grid
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        // If the cell is already visited, skip it
        if (visited[i][j]) {
          continue;
        }
        // Explore the current node and find connected land cells
        traverseNodes(grid, visited, i, j, sizes);
      }
    }
    // The total number of islands is the number of sizes recorded
    return sizes.size();
  }

  // Method to perform DFS traversal on the grid to find connected land cells
  private static void traverseNodes(char[][] matrix, boolean[][] visited, int i, int j, List<Integer> sizes) {
    int size = 0; // To keep track of the current island size
    int[] array = {i, j}; // Current cell coordinates

    // Use a stack for DFS traversal
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(array);

    // Perform DFS traversal
    while (stack.size() > 0) {
      // Pop the current node from the stack
      int[] currNode = stack.pop();
      int a = currNode[0]; // Row index
      int b = currNode[1]; // Column index

      // If the node is already visited, skip it
      if (visited[a][b])
        continue;

      // Mark the current node as visited
      visited[a][b] = true;

      // If the current node is water ('0'), do not explore further
      if (matrix[a][b] == '0')
        continue;

      // Increment size for every land cell ('1') found
      size++;

      // Get all unvisited neighbors of the current cell
      Deque<int[]> unvisited = getUnvisited(a, b, matrix, visited);

      // Push all unvisited neighbors onto the stack for further exploration
      for (int[] node : unvisited) {
        stack.push(node);
      }
    }

    // If we have found at least one land cell, add the island size to the list
    if (size > 0) {
      sizes.add(size);
    }
  }

  // Helper method to get all unvisited neighboring cells (up, down, left, right)
  private static Deque<int[]> getUnvisited(int i, int j, char[][] matrix, boolean[][] visited) {
    Deque<int[]> uNodes = new ArrayDeque<>();

    // Check the top neighbor
    if (i > 0 && !visited[i - 1][j]) {
      uNodes.push(new int[]{i - 1, j});
    }

    // Check the left neighbor
    if (j > 0 && !visited[i][j - 1]) {
      uNodes.push(new int[]{i, j - 1});
    }

    // Check the bottom neighbor
    if (i < matrix.length - 1 && !visited[i + 1][j]) {
      uNodes.push(new int[]{i + 1, j});
    }

    // Check the right neighbor
    if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
      uNodes.push(new int[]{i, j + 1});
    }

    return uNodes;
  }
}
