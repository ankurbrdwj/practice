package com.ankur.interview.practice.graphs;

import java.util.*;

/*
 * PROBLEM: Clone Graph (LeetCode 133) — Iterative DFS + HashMap
 *
 * Given a reference to a node in a connected undirected graph, return a deep
 * copy of the entire graph. Each node has an int value and a list of neighbors.
 *
 * Key challenge: the graph may have cycles. Without tracking visited nodes
 * you'd recurse infinitely. A hashmap (old → clone) solves both problems:
 * it acts as the visited set AND gives you the clone for any node instantly.
 *
 * Approach:
 *   1. Clone the start node and push it onto a stack.
 *   2. Pop a node, iterate its neighbors.
 *   3. If a neighbor hasn't been cloned yet, clone it and push for later.
 *   4. Either way, wire clone(curr) → clone(neighbor) as a neighbor edge.
 *
 * Time  O(V + E) — every node and edge visited once
 * Space O(V)     — hashmap + stack hold at most V entries
 *
 * Example:
 *   Input:  adjList = [[2,4],[1,3],[2,4],[1,3]]   (4-node cycle-like graph)
 *   Output: [[2,4],[1,3],[2,4],[1,3]]              (identical structure, new nodes)
 *
 *   Input:  adjList = [[]]   → single node, no neighbors
 *   Input:  adjList = []     → null input → return null
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;                      // empty graph

        Map<Node, Node> cloned = new HashMap<>();           // old node → its clone
        Deque<Node> stack = new ArrayDeque<>();

        cloned.put(node, new Node(node.val));               // clone the entry point
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();                        // process next original node

            for (Node neighbor : curr.neighbors) {
                if (!cloned.containsKey(neighbor)) {        // first time seeing this neighbor
                    cloned.put(neighbor, new Node(neighbor.val)); // clone it
                    stack.push(neighbor);                   // schedule it for edge wiring
                }
                // wire the edge: clone(curr) must point to clone(neighbor)
                cloned.get(curr).neighbors.add(cloned.get(neighbor));
            }
        }

        return cloned.get(node);                            // return clone of the entry node
    }
}