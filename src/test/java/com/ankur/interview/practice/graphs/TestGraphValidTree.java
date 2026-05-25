package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphValidTree {

    private final GraphValidTree solution = new GraphValidTree();

    // --- RED: single node ---
    @Test
    public void singleNode_noEdges_isValidTree() {
        assertTrue(solution.isGraphValidTree(1, new int[][]{}));
    }

    // --- RED: two nodes ---
    @Test
    public void twoNodes_oneEdge_isValidTree() {
        assertTrue(solution.isGraphValidTree(2, new int[][]{{0, 1}}));
    }

    @Test
    public void twoNodes_noEdge_isNotValidTree() {
        assertFalse(solution.isGraphValidTree(2, new int[][]{}));
    }

    // --- RED: standard valid tree ---
    @Test
    public void fiveNodes_validTree_isTrue() {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        assertTrue(solution.isGraphValidTree(5, edges));
    }

    // --- RED: linear chain ---
    @Test
    public void fourNodes_linearChain_isValidTree() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        assertTrue(solution.isGraphValidTree(4, edges));
    }

    // --- RED: cycle present ---
    @Test
    public void fiveNodes_withCycle_isFalse() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        assertFalse(solution.isGraphValidTree(5, edges));
    }

    @Test
    public void threeNodes_triangleCycle_isFalse() {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        assertFalse(solution.isGraphValidTree(3, edges));
    }

    // --- RED: disconnected graph ---
    @Test
    public void fiveNodes_disconnected_isFalse() {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        assertFalse(solution.isGraphValidTree(5, edges));
    }

    @Test
    public void fourNodes_twoIsolatedComponents_isFalse() {
        int[][] edges = {{0, 1}, {2, 3}};
        assertFalse(solution.isGraphValidTree(4, edges));
    }
}