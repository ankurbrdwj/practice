package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCloneGraph {

    private final CloneGraph solution = new CloneGraph();

    // Build a graph from an adjacency list where index i (1-based) lists neighbor vals.
    // e.g. adjList = [[2,4],[1,3],[2,4],[1,3]] → 4-node graph
    private CloneGraph.Node build(int[][] adjList) {
        if (adjList.length == 0) return null;
        CloneGraph.Node[] nodes = new CloneGraph.Node[adjList.length + 1];
        for (int i = 1; i <= adjList.length; i++) nodes[i] = new CloneGraph.Node(i);
        for (int i = 1; i <= adjList.length; i++)
            for (int nb : adjList[i - 1]) nodes[i].neighbors.add(nodes[nb]);
        return nodes[1];
    }

    // Collect adjacency structure of cloned graph for comparison (BFS order by val).
    private Map<Integer, List<Integer>> toAdjMap(CloneGraph.Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        if (root == null) return map;
        Queue<CloneGraph.Node> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(root);
        seen.add(root.val);
        while (!q.isEmpty()) {
            CloneGraph.Node n = q.poll();
            List<Integer> nbVals = new ArrayList<>();
            for (CloneGraph.Node nb : n.neighbors) {
                nbVals.add(nb.val);
                if (seen.add(nb.val)) q.add(nb);
            }
            Collections.sort(nbVals);
            map.put(n.val, nbVals);
        }
        return map;
    }

    // Returns true if every original node has a distinct clone object (deep copy).
    private boolean isDeepCopy(CloneGraph.Node original, CloneGraph.Node clone) {
        Queue<CloneGraph.Node> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q1.add(original); q2.add(clone); seen.add(original.val);
        while (!q1.isEmpty()) {
            CloneGraph.Node o = q1.poll(), c = q2.poll();
            if (o == c) return false; // same reference → not a deep copy
            for (int i = 0; i < o.neighbors.size(); i++) {
                CloneGraph.Node on = o.neighbors.get(i), cn = c.neighbors.get(i);
                if (seen.add(on.val)) { q1.add(on); q2.add(cn); }
            }
        }
        return true;
    }

    // Standard 4-node graph from LeetCode example: [[2,4],[1,3],[2,4],[1,3]]
    @Test
    public void testFourNodeGraph_structurePreserved() {
        CloneGraph.Node original = build(new int[][]{{2,4},{1,3},{2,4},{1,3}});
        CloneGraph.Node clone    = solution.cloneGraph(original);
        assertEquals(toAdjMap(original), toAdjMap(clone));
    }

    @Test
    public void testFourNodeGraph_isDeepCopy() {
        CloneGraph.Node original = build(new int[][]{{2,4},{1,3},{2,4},{1,3}});
        CloneGraph.Node clone    = solution.cloneGraph(original);
        assertTrue(isDeepCopy(original, clone));
    }

    // Single node with no neighbors
    @Test
    public void testSingleNode() {
        CloneGraph.Node original = build(new int[][]{{}});
        CloneGraph.Node clone    = solution.cloneGraph(original);
        assertEquals(1, clone.val);
        assertTrue(clone.neighbors.isEmpty());
        assertNotSame(original, clone);
    }

    // null input → null output
    @Test
    public void testNullInput() {
        assertNull(solution.cloneGraph(null));
    }

    // Linear chain: 1 → 2 → 3 (directed edges as undirected: each points to both neighbors)
    @Test
    public void testLinearChain() {
        CloneGraph.Node original = build(new int[][]{{2},{1,3},{2}});
        CloneGraph.Node clone    = solution.cloneGraph(original);
        assertEquals(toAdjMap(original), toAdjMap(clone));
        assertTrue(isDeepCopy(original, clone));
    }
}