package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.MinNoOfJumps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMinNoOfJumps {
    @Test
    public void TestCase1() {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        Assertions.assertTrue(MinNoOfJumps.minNumberOfJumps(input) == 4);
    }

}
