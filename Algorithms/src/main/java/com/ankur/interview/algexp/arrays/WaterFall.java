package com.ankur.interview.algexp.arrays;

import java.util.Arrays;

public class WaterFall {

    public static double[] getWaterPercentages(double[][] array, int source) {

        double[] prevRow = array[0];
        prevRow[source] = -1;
        for (int j = 1; j < array.length; j++) {
            double[] currRow = array[j];
            for (int k = 0; k < prevRow.length; k++) {
                double valueAbove = prevRow[k];
                boolean hasWaterAbove = valueAbove < 0;
                boolean hasBlock = currRow[k] == 1.0;

                if (!hasWaterAbove)
                    continue;
                if (!hasBlock) {
                    currRow[k] += valueAbove;
                    continue;
                }
                double splitWater = valueAbove / 2;
                // mover right
                int rightIdx = k;
                while (rightIdx + 1 < prevRow.length) {
                    rightIdx += 1;
                    if (prevRow[rightIdx] == 1.0) {// there is block
                        break;
                    }
                    if (currRow[rightIdx] != 1) { // move water down and break
                        currRow[rightIdx] += splitWater;
                        break;
                    }
                }
                int leftIdx = k;
                while (leftIdx - 1 >= 0) {
                    leftIdx -= 1;
                    if (prevRow[leftIdx] == 1.0) {
                        break;
                    }
                    if (currRow[leftIdx] != 1) {
                        currRow[leftIdx] += splitWater;
                        break;
                    }
                }
            }
            prevRow = currRow;
        }
        double[] finalPercent = new double[prevRow.length];
        for (int i = 0; i < prevRow.length; i++) {
            double num = prevRow[i];
            if (num == 0) {
                finalPercent[i] = num;
            } else {
                finalPercent[i] = num * -100;
            }
        }
        return finalPercent;
    }

    public static void main(String[] args) {
        double [][] a= {
                {0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,1,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0}
        };
       double[] result =  getWaterPercentages(a,3);
        Arrays.stream(result)
                .forEach(System.out::println);
    }
}
