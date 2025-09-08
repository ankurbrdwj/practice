package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTwoColorable {
    @Test
    public void TestCase1() {
        int[][] input = new int[][] {{1}, {0}};
        var expected = true;
        var actual = new BipartiteColoring().twoColorable(input);
        Assertions.assertEquals(expected ,actual);
    }
}