package com.ankur.interview.practice.graphs;

import java.util.ArrayList;
import java.util.List;

public class AlgoExpertDFS {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (int i = 0; i < children.size(); i++) {
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node graph= new Node("ABEFIJCDGKH");
        List<String> result= graph.depthFirstSearch(new ArrayList<String>());
        for (String s:result) {
            System.out.printf(s);
        }
    }
}
