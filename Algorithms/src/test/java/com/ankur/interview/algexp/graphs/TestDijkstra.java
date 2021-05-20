package com.ankur.interview.algexp.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDijkstra {
    @Test
    public void testCase1() {
        int start = 0;
        int[][][] edges = {
                {{1, 7}}
                , {{2, 6}, {3, 20}, {4, 3}}
                , {{3, 14}}
                , {{4, 2}}
                , {}
                , {}};
        int[] result = Dijkstra.dijkstrasAlgorithm(start,edges);
        int[] expected  = {0,7,13,27,10,-1};
        Assertions.assertTrue(result.length==expected.length);
        for(int i =0;i<result.length;i++){
            Assertions.assertTrue(result[i]==expected[i]);

        }
    }
}
