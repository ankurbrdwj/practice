package com.ankur.interview.practice.graphs;

import java.util.ArrayList;

public class MinPassesOfMatrix {
    public int minimumPassesOfMatrix(int[][] matrix) {
        /*
        / get all positives , set pass to 0
        like bfs for each in queue get adjacent  and
        check if value is <0 the * 1 and add to queue
        set size of queue -1 , set pass+1
         */
        int passes = convertNegatives(matrix);
        return (!containsNegatives(matrix)) ? passes - 1 : -1;
    }

    private boolean containsNegatives(int[][] matrix) {
        for (int[] row:matrix){
            for(int value:row){
                if(value<0){
                    return true;
                }
            }
        }
        return false;
    }

    public int convertNegatives(int[][] matrix){
        ArrayList<int[]> queue = getAllPositives(matrix);
        int passes = 0;
        while (queue.size() > 0) {
            int currentSize = queue.size();
            while (currentSize > 0) {
                int[] vals = queue.remove(0);
                int row = vals[0];
                int col = vals[1];
                ArrayList<int[]> adj = getAdjacentPositions(row, col, matrix);
                for (int[] node : adj) {
                    int rowP = node[0];
                    int colP = node[1];
                    int value = matrix[rowP][colP];
                    if (value < 0) {
                        matrix[rowP][colP] *= -1;
                        queue.add(new int[]{rowP, colP});
                    }
                }
                currentSize--;
            }
            passes++;
        }
        return passes;
    }

    private ArrayList<int[]> getAdjacentPositions(int row, int col, int[][] matrix) {
        ArrayList<int[]> adjacent = new ArrayList<>();
        if (row > 0) {
            adjacent.add(new int[]{row - 1, col});
        }
        if (row < matrix.length - 1) {
            adjacent.add(new int[]{row + 1, col});
        }
        if (col > 0) {
            adjacent.add(new int[]{row, col - 1});
        }
        if (col < matrix[0].length - 1) {
            adjacent.add(new int[]{row, col + 1});
        }
        return adjacent;
    }

    private ArrayList<int[]> getAllPositives(int[][] matrix) {
        ArrayList<int[]> positives = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int value = matrix[row][col];
                if (value > 0) {
                    positives.add(new int[]{row, col});
                }
            }
        }
        return positives;
    }
}
