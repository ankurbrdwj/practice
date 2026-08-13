package com.ankur.interview.practice.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

// Given an undirected graph as an adjacency list, determine whether it is bipartite —
// i.e., every node can be assigned one of two colors such that no two adjacent nodes
// share the same color.
//
// Input:  int[][] graph where graph[i] lists all nodes directly connected to node i
// Output: true if bipartite, false otherwise
//
// Example 1 (true):
//   Input:  [[1,3],[0,2],[1,3],[0,2]]
//   Graph:  0-1-2-3-0  (a 4-cycle)
//   Output: true  — color {0,2} red, {1,3} blue
//
// Example 2 (false):
//   Input:  [[1,2,3],[0,2],[0,1,3],[0,2]]
//   Graph:  contains an odd-length cycle (triangle 0-1-2)
//   Output: false — impossible to 2-color a triangle
public class BipartiteColoring {
    public boolean twoColorable(int[][] input) {
        int [] color = new int[input.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        color[0]=1;
        while(!stack.isEmpty()){
            int node= stack.pop();
            for(int connection: input[node]){
                if(color[connection]==0){ //empty first time or not visited
                    color[connection]= color[node]==1?2:1; //setting toggle from 1 when for first time
                    stack.push(connection); // will see its neighbours
                } else if (color[connection]== color[node]) { // was already colored or was visited
                    return false;
                }
            }
        }
        return true;
    }
}
