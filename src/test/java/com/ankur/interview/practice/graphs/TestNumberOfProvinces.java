package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNumberOfProvinces {

    private final NumberOfProvinces solution = new NumberOfProvinces();

    // 3 cities: 0-1 connected, 2 alone → 2 provinces
    @Test
    public void testTwoProvinces() {
        int[][] m = {{1,1,0},{1,1,0},{0,0,1}};
        assertEquals(2, solution.findCircleNum(m));
    }

    // 3 cities all separate → 3 provinces
    @Test
    public void testAllDisconnected() {
        int[][] m = {{1,0,0},{0,1,0},{0,0,1}};
        assertEquals(3, solution.findCircleNum(m));
    }

    // 3 cities all connected → 1 province
    @Test
    public void testAllConnected() {
        int[][] m = {{1,1,1},{1,1,1},{1,1,1}};
        assertEquals(1, solution.findCircleNum(m));
    }

    // Single city → 1 province
    @Test
    public void testSingleCity() {
        assertEquals(1, solution.findCircleNum(new int[][]{{1}}));
    }

    // 4 cities: 0-1 connected, 2-3 connected → 2 provinces
    @Test
    public void testTwoPairsOfCities() {
        int[][] m = {
            {1,1,0,0},
            {1,1,0,0},
            {0,0,1,1},
            {0,0,1,1}
        };
        assertEquals(2, solution.findCircleNum(m));
    }
}