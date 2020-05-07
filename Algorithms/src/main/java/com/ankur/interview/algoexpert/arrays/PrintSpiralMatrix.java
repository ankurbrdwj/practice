package com.ankur.interview.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {

    public static List<Integer> spiralTraverse(int[][] a) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = a.length - 1;
        int startCol= 0;
        int endCol = a[0].length - 1;
        while (startRow <= endRow && startCol<= endCol) {
            for (int i = startRow; i <= endCol; i++) {
                result.add(a[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(a[i][endCol]);
            }
            if (startRow + 1 <= endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    result.add(a[endRow][i]);
                }
            }
            if (startCol+ 1 <= endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    result.add(a[i][startCol]);
                }
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }
}
