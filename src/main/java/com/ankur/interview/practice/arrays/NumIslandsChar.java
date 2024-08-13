package com.ankur.interview.practice.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumIslandsChar {
  public static int numIslands(char[][] grid) {
    boolean[][] visited = new boolean[grid.length][];
    for (int i = 0; i < grid.length; i++) {
      visited[i] = new boolean[grid[i].length];
      for (int j = 0; j < grid[i].length; j++) {
        visited[i][j] = false;
      }
    }
    List<Integer> sizes = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (visited[i][j]) {
          continue;
        }
        traverseNodes(grid, visited, i, j, sizes);
      }
    }
    return sizes.size();
  }

  private static void traverseNodes(char[][] matrix, boolean[][] visited, int i, int j, List<Integer> sizes) {
    int size = 0;
    int[] array = {i, j};
    // dfs
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(array);
    while (stack.size() > 0) {
      int[] currNode = stack.pop();
      int a = currNode[0];
      int b = currNode[1];
      if (visited[a][b])
        continue;
      visited[a][b] = true;
      // not interested in ones
      if (matrix[a][b] == '0')
        continue;
      size++;
      Deque<int[]> unvisited = getUnivisited(a, b, matrix, visited);
      for (int[] node : unvisited) {
        stack.push(node);
      }
    }
    if (size > 0) {
      sizes.add(size);
    }
  }

  private static Deque<int[]> getUnivisited(int i, int j, char[][] matrix, boolean[][] visited) {
    Deque<int[]> uNodes = new ArrayDeque<>();
    if (i > 0 && !visited[i - 1][j]) {
      uNodes.push(new int[]{i - 1, j});
    }
    if (j > 0 && !visited[i][j - 1]) {
      uNodes.push(new int[]{i, j - 1});
    }
    if (i < matrix.length - 1 && !visited[i + 1][j]) {
      uNodes.push(new int[]{i + 1, j});
    }
    if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
      uNodes.push(new int[]{i, j + 1});
    }
    return uNodes;
  }

}
