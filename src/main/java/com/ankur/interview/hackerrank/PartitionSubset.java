package com.ankur.interview.hackerrank;

public class PartitionSubset {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 != 0)
            return false;
        return canPartition(nums, 0, 0, total);
    }

    private boolean canPartition(int[] nums, int index, int sum, int total) {
        if (sum * 2 == total) {
            return true;
        }
        if (sum > total / 2 || index >= nums.length) {
            return false;
        }
        return canPartition(nums, index + 1, sum, total) || canPartition(nums, index + 1, sum + nums[index], total);
    }

}
