package com.ankur.interview.practice.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

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
