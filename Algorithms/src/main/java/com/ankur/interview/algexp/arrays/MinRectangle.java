package com.ankur.interview.algexp.arrays;

import java.util.HashSet;

public class MinRectangle {
    public int minRectangleArea(int[][] points) {
        HashSet<String> pointSet = getPointSet(points);
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int p2x = points[i][0];
            int p2y = points[i][1];
            for (int prev = 0; prev < i; prev++) {
                int p1x = points[prev][0];
                int p1y = points[prev][1];
                boolean ifNotDiagonal = p1x == p2x || p1y == p2y;
                if (ifNotDiagonal)
                    continue;
                boolean p1xp2yExits = pointSet.contains(convertPointToString(p1x, p2y));
                boolean p2xp1yExixts = pointSet.contains(convertPointToString(p2x, p1y));
                if (p1xp2yExits && p2xp1yExixts) {
                    int currentArea = Math.abs(p2x - p1x) * Math.abs(p2y - p1y);
                    minArea = Math.min(minArea, currentArea);
                }
            }
        }
        return minArea;
    }

    private HashSet<String> getPointSet(int[][] points) {
        HashSet<String> result = new HashSet<>();
        for (int[] point : points
        ) {
            int x = point[0];
            int y = point[1];
            result.add(convertPointToString(x, y));
        }
        return result;
    }

    private String convertPointToString(int x, int y) {
        return String.valueOf(x) + " : " + String.valueOf(y);
    }
}
