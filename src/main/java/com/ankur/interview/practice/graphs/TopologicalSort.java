package com.ankur.interview.practice.graphs;

import java.util.*;

// Topological Sort — orders jobs so every prerequisite comes before the job
// that depends on it. Only valid on a Directed Acyclic Graph (DAG); if a
// cycle exists there is no valid ordering and we return an empty list.
//
// APPROACH: DFS post-order
//   Visit every node. When ALL of a node's prerequisites have been fully
//   explored, append that node to the result. Because prereqs are appended
//   first, the final list is always in dependency order.
//
// THREE-COLOR NODE STATE (classic cycle-detection trick):
//   visiting=false  visited=false  →  WHITE  (never seen)
//   visiting=true   visited=false  →  GRAY   (on the current DFS stack)
//   visiting=false  visited=true   →  BLACK  (fully resolved, safe to skip)
//
//   Hitting a GRAY node during DFS means we followed an edge back to an
//   ancestor still on the stack — that's a cycle.
//
// EXAMPLE  jobs=[1,2,3,4]  deps=[{1→2},{1→3},{3→2},{4→2},{4→3}]
//   dep[0] is a prereq of dep[1], so the graph edges are:
//     2.preReqs = [1, 3, 4]    3.preReqs = [1, 4]    1.preReqs = []    4.preReqs = []
//
//   DFS from node 4 (last in list):
//     visit 4 → visit prereqs of 4 (none) → append 4   result=[4]
//     visit 3 → visit prereq 1 → append 1, visit prereq 4 (BLACK, skip) → append 3
//     result=[4,1,3]
//     visit 2 → prereqs 1,3,4 all BLACK → append 2     result=[4,1,3,2]
//     visit 1 → already BLACK, skip
//   Valid order: 4 → 1 → 3 → 2  (every job appears after all its prereqs) ✓
public class TopologicalSort {

    public static List<Integer> getOrderedJobs(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = createJobGraph(jobs, deps);
        return getOrderedResult(graph);
    }

    private static List<Integer> getOrderedResult(JobGraph graph) {
        List<Integer> result = new ArrayList<>();
        List<JobNode> nodes = new ArrayList<>(graph.nodes);
        while (nodes.size() > 0) {
            JobNode node = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            boolean containsCycle = depthFirstTraversal(node, result);
            if (containsCycle) {
                return new ArrayList<>();
            }
        }
        return result;
    }

    private static boolean depthFirstTraversal(JobNode node, List<Integer> result) {
        // BLACK — already fully resolved and appended; nothing left to do.
        if (node.visited) return false;
        // GRAY — we reached a node that's still on the current DFS stack.
        // An ancestor depends on us and we depend on it: that's a cycle.
        if (node.visiting) return true;

        // Mark GRAY: we're entering this node's subtree.
        node.visiting = true;

        // Recurse into every prerequisite before we can resolve this node.
        // If any prereq subtree contains a cycle, bubble it up immediately.
        for (JobNode jobNode : node.preReqs) {
            boolean cycle = depthFirstTraversal(jobNode, result);
            if (cycle) {
                return true;
            }
        }

        // POST-ORDER: all prerequisites are now BLACK and already sit in
        // result ahead of us. Appending here guarantees this node appears
        // after every job it depends on — the core of topological ordering.
        node.visited  = true;   // transition GRAY → BLACK
        node.visiting = false;
        result.add(node.job);
        return false;
    }

    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs);
        for (Integer[] dep : deps) {
            graph.addPrereqs(dep[1], dep[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        Integer[][] depsArray = new Integer[][]{{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};
        List<Integer[]> deps = new ArrayList<Integer[]>();
        fillDeps(depsArray, deps);

        List<Integer> order = TopologicalSort.getOrderedJobs(jobs, deps);
        boolean result = isValidTopologicalOrder(order, jobs, deps);
        System.out.println(result);
    }

    static void fillDeps(Integer[][] depsArray, List<Integer[]> deps) {
        for (Integer[] depArray : depsArray) {
            deps.add(depArray);
        }
    }

    static boolean isValidTopologicalOrder(List<Integer> order, List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for (Integer candidate : order) {
            for (Integer[] dep : deps) {
                if (candidate == dep[0] && visited.containsKey(dep[1])) return false;
            }
            visited.put(candidate, true);
        }
        for (Integer job : jobs) {
            if (!visited.containsKey(job)) return false;
        }
        return order.size() == jobs.size();
    }

    static class JobGraph {
        List<JobNode> nodes;
        Map<Integer, JobNode> graph;

        public JobGraph(List<Integer> jobs) {
            nodes = new ArrayList<JobNode>();
            graph = new HashMap<>();
            for (Integer job : jobs) {
                addNode(job);
            }
        }

        private void addNode(Integer job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }

        public JobNode getNode(Integer job) {
            if (!graph.containsKey(job)) addNode(job);
            return graph.get(job);
        }

        public void addPrereqs(int i, int j) {
            JobNode node = this.getNode(i);
            JobNode preNode = this.getNode(j);
            node.preReqs.add(preNode);
        }
    }

    static class JobNode {
        public List<JobNode> preReqs;
        public Integer job;
        public boolean visited;
        public boolean visiting;

        public JobNode(int job) {
            this.job = job;
            this.preReqs = new ArrayList<>();
            this.visited = false;
            this.visiting = false;
        }
    }
}

