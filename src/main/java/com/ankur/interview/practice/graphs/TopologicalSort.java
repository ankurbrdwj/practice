package com.ankur.interview.practice.graphs;

import java.util.*;

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
        if (node.visited) return false;
        if (node.visiting) return true;
        node.visiting = true;

        for (JobNode jobNode : node.preReqs) {
            boolean cycle = depthFirstTraversal(jobNode, result);
            if (cycle) {
                return true;
            }
        }
        node.visited = true;
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

