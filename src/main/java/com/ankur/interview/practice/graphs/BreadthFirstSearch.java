package com.ankur.interview.practice.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
/BFS Implementation:
The breadthFirstSearch method implements BFS.
It uses a Deque (double-ended queue) as the queue for BFS, which is appropriate.
The method starts with the current node (this) and explores all neighbors before moving to the next level.
Queue Operations:
queue.add(this) adds the starting node to the queue.
queue.poll() removes and returns the first element of the queue.
queue.addAll(current.children) adds all children of the current node to the queue.
Result Collection:
The method collects node names in the order they are visited, storing them in the array list.
No Visited Set:This implementation doesn't use a visited set, which is okay for tree structures where there are no cycles.
However, if this were to be used on a graph with cycles, a visited set would be necessary to prevent infinite loops.
Child Addition:
The addChild method allows for easy addition of child nodes, facilitating the construction of the tree.
This implementation is efficient and correct for tree traversals. It will visit all nodes in a breadth-first manner, exploring all nodes at the current depth before moving to the nodes at the next depth level.
However, if this code were to be used on a graph with cycles or if there's a possibility of reaching the same node through different paths, you would need to add a visited set to prevent revisiting nodes.
 */
public class BreadthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Deque<Node> queue = new ArrayDeque<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                array.add(current.name);
                queue.addAll(current.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
