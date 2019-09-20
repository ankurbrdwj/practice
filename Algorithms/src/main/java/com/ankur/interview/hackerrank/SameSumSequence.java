package com.ankur.interview.hackerrank;

import java.util.HashMap;

/*
/ Longest common sequence with same sum
 */
public class SameSumSequence {
    public static void main(String[] arge) {
        int[] array1 = {0,1,0,1,1,1,0,0,1,1,0,1};
        int[] array2 = {1,0,1,0,0,0,0,0,1,1,0,1};
        int startIndex = 0;
        int lastIndex = 0;
        int length = usingAuxArray(array1, array2);
        System.out.println(length);
        length = usingHashing(array1, array2);
        System.out.println(length);
    }

    private static int usingHashing(int[] array1, int[] array2) {
        // Find difference between the two
        int n = array1.length;
        int ending_index = -1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = array1[i] - array2[i];
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0;     // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < n; i++)
        {
            // Add current element to sum
            sum += arr[i];

            // To handle sum=0 at last index
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }
            // If this sum is seen before,
            // then update max_len if required
            if (hM.containsKey(sum)) {
                max_len = Math.max(max_len, i - hM.get(sum));
                ending_index=i;
            }

            else // Else put this sum in hash table
                hM.put(sum, i);
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);
        return max_len;
    }

    private static int usingAuxArray(int[] array1, int[] array2) {
        int[] diff = new int[2 * array1.length + 1];
        // Initialize all starting and ending values as -1.
        for (int i = 0; i < diff.length; i++) {
            diff[i] = -1;
        }
        int maxLen = 0;
        int n = array1.length;
        int preSum1 = 0;
        int preSum2 = 0;
        // Traverse both arrays
        for (int i = 0; i < n; i++) {
            // Update prefix sums
            preSum1 += array1[i];
            preSum2 += array2[i];

            // Comput current diff and index to be used
            // in diff array. Note that diff can be negative
            // and can have minimum value as -1.
            int curr_diff = preSum1 - preSum2;
            int diffIndex = n + curr_diff;

            // If current diff is 0, then there are same number
            // of 1's so far in both arrays, i.e., (i+1) is
            // maximum length.
            if (curr_diff == 0)
                maxLen = i + 1;

                // If current diff is seen first time, then update
                // starting index of diff.
            else if (diff[diffIndex] == -1)
                diff[diffIndex] = i;

                // Current diff is already seen
            else {
                // Find length of this same sum common span
                int len = i - diff[diffIndex];

                // Update max len if needed
                if (len > maxLen)
                    maxLen = len;
            }
        }
        return 0;
    }

}
