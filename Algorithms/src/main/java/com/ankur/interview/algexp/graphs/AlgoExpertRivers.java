package com.ankur.interview.algexp.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AlgoExpertRivers {


    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            visited[i] = new boolean[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                traverseNodes(i, j, matrix, visited, sizes);
            }
        }
        return sizes;
    }

    private static  void traverseNodes(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int riverSize = 0;
        int[] array = {i, j};
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(array);
        while (stack.size() > 0) {
            int[] currNode = stack.pop();
            int a = currNode[0];
            int b = currNode[1];
            if (visited[a][b])
                continue;
            visited[a][b] = true;
            if (matrix[a][b] == 0)
                continue;
            riverSize += 1;
            Deque<int[]> unvisitedNodes = getUnvisitedNodes(a, b, matrix, visited);
            for (int[] node : unvisitedNodes) {
                stack.push(node);
            }
        }
        if (riverSize > 0) {
            sizes.add(riverSize);
        }
    }

    private static Deque<int[]> getUnvisitedNodes(int i, int j, int[][] matrix, boolean[][] visited) {
        Deque<int[]> uNodes = new ArrayDeque<>();
        if (i > 0 && !visited[i - 1][j]) {
            uNodes.push(new int[]{i - 1, j});
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {
            uNodes.push(new int[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            uNodes.push(new int[]{i, j - 1});
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            uNodes.push(new int[]{i, j + 1});
        }
        return uNodes;
    }

    public static void main(String[] args) {
        List<Integer> result = riverSizes(new int[][]{{1,1,1,0,1,1,0,0,0,1,0}});
        for (Integer i:result
             ) {
            System.out.printf(i+" ,");
        }
    }
}
