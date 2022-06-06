package com.ankur.interview.algexp.dynamicprogramming;

public class MinNoOfJumps {
    public static int minNumberOfJumps(int[] array) {
        if (array.length == 1)
            return 0;
        // Write your code here.
        int maxIndex = array[0];
        int steps = array[0];
        int jumps = 0;
        for (int i = 1; i < array.length - 1; i++) {
            maxIndex = Math.max(maxIndex, (i + array[i]));
            steps--;  // one i is one step
            if (steps == 0) {
                jumps++;
                steps = maxIndex - i;
            }
        }
        return jumps + 1;
    }
}

