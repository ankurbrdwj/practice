package com.ankur.interview.practice.graphs;

import java.util.*;

public class RemoveIsland{

  public int[][] removeIslands(int[][] matrix) {
    // Write your code here.
    boolean[][] connectedToBorder = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      connectedToBorder[i][matrix[0].length - 1] = false;
    }
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        boolean isRowBorder = row == 0 || row ==matrix.length - 1;
        boolean isColBorder = col == 0 || col ==matrix[row].length - 1;
        boolean isBorder = isRowBorder || isColBorder;
        if (!isBorder) {
          continue;
        }
        if (matrix[row][col] != 1) {
          continue;
        }
        findOnesConnectedToBorder(matrix, row, col, connectedToBorder);
      }
    }
    for (int i = 1;i< matrix.length-1;i++){
      for(int j =1;j< matrix[i].length-1;j++){
        if(connectedToBorder[i][j]){
          continue;
        }
        matrix[i][j]=0;
      }
    }
    return matrix;
  }

  private void findOnesConnectedToBorder(int[][] matrix, int row, int col, boolean[][] connectedToBorder) {
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(new int[]{row, col});
    while (stack.size()>0) {
      int[] currentPos = stack.pop();
      int currentRow = currentPos[0];
      int currentCol = currentPos[1];
      boolean visited = connectedToBorder[currentRow][currentCol];
      if (visited) {
        continue;
      }
      connectedToBorder[currentRow][currentCol] = true;
      int[][] neighbours = getNeighbours(matrix, currentRow, currentCol);
      for (int[] neighbour : neighbours) {
        int nRow = neighbour[0];
        int nCol = neighbour[1];
        if (matrix[nRow][nCol] != 1) {
          continue;
        }
        stack.push(neighbour);
      }
    }
  }

  private int[][] getNeighbours(int[][] matrix, int currentRow, int currentCol) {
    ArrayList<int[]> list = new ArrayList<>();
    int numRows = matrix.length;
    int numCols = matrix[currentRow].length;
    if (currentRow - 1 >= 0) {
      list.add(new int[]{currentRow - 1, currentCol});
    }
    if (currentRow + 1 < numRows) {
      list.add(new int[]{currentRow + 1, currentCol});
    }
    if (currentCol - 1 >= 0) {
      list.add(new int[]{currentRow, currentCol - 1});
    }
    if (currentCol + 1 < numCols) {
      list.add(new int[]{currentRow, currentCol + 1});
    }
    int[][] neighbours = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      neighbours[i] = list.get(i);
    }
    return neighbours;
  }
}
