package com.ankur.interview.algexp.arrays;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversal {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;
        int row = 0;
        int col = 0;
        boolean goDown = true;
        List<Integer> result = new ArrayList<>();
        while (!afterEdge(row, col, height, width)) {
            result.add(array.get(row).get(col));
            if (goDown) {
                if (col == 0 || row == height) {
                    goDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col++;
                }
            } else {
                if (row == 0 || col == width) {
                    goDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }
        return result;
    }

    public static boolean afterEdge(int row, int col, int height, int width) {
        return (row < 0 || col < 0 || row > height || col > width);
    }
}

