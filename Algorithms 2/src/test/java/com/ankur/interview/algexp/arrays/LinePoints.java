package com.ankur.interview.algexp.arrays;

import java.util.HashMap;
import java.util.Map;

public class LinePoints {

    public static int getLinePoints(int[][] points) {
        int maxPoints = 1;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            HashMap<String, Integer> slopeCount = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                String slope = findSlope(p1[0], p1[1], p2[0], p2[1]);
                if (!slopeCount.containsKey(slope)) {
                    slopeCount.put(slope, 1);
                }
                slopeCount.put(slope, slopeCount.get(slope) + 1);
            }
            int currentMax = getMaxSlopCount(slopeCount);
            if(maxPoints<currentMax)
                maxPoints=currentMax;
        }
        return maxPoints;
    }

    private static int getMaxSlopCount(HashMap<String, Integer> slopeCount) {
        int current = 0;
        for (Map.Entry<String, Integer> entry : slopeCount.entrySet()) {
            current = Math.max(entry.getValue(), current);
        }
        return current;
    }

    public static String findSlope(int x1, int y1, int x2, int y2) {
        int yDiff = y2 - y1;
        int xDiff = x2 - x1;
        int gcd = getGCD(yDiff, xDiff);
        yDiff = yDiff / gcd;
        xDiff = xDiff / gcd;
        if (xDiff < 0) {
            xDiff *= -1;
            yDiff *= -1;
        }
        return String.valueOf(yDiff) + ":" + String.valueOf(xDiff);
    }

    private static int getGCD(int i, int j) {
        int a = i;
        int b = j;
        while (true) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            int temp = a;
            a = b;
            b = temp % b;
        }
    }

    public static void main(String[] args) {
         int[][] a= {{1,1},{2,2},{3,3},{0,4},{-2,6},{4,0},{2,1}};
         int expected = getLinePoints(a);
        System.out.println(expected);
    }
}
