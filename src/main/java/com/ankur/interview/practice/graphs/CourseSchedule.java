package com.ankur.interview.practice.graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * Course Schedule (LeetCode 207) — DFS Cycle Detection in Directed Graph
 *
 * Model courses as nodes and prerequisites as directed edges.
 * If the dependency graph has a cycle, it's impossible to finish all courses.
 *
 * 3-color DFS:
 *   0 = unvisited
 *   1 = in current DFS path (visiting) — seeing this again means a cycle
 *   2 = fully processed (no cycle through this node)
 *
 * Time  O(V + E)
 * Space O(V + E)
 *
 * Example: numCourses=2, prerequisites=[[1,0]] → true (take 0 then 1)
 * Example: numCourses=2, prerequisites=[[1,0],[0,1]] → false (cycle)
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) adj.get(pre[0]).add(pre[1]);

        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adj, state, i)) return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] state, int node) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;
        state[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (hasCycle(adj, state, neighbor)) return true;
        }
        state[node] = 2;
        return false;
    }
}