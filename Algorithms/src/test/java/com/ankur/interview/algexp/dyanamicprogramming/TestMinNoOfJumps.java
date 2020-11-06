package com.ankur.interview.algexp.dyanamicprogramming;

import com.ankur.interview.algexp.dynamicprogramming.MinNoOfJumps;
import jogamp.graph.font.typecast.ot.table.Program;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMinNoOfJumps {
    @Test
    public void TestCase1() {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        Assertions.assertTrue(MinNoOfJumps.minNumberOfJumps(input) == 4);
    }

}
