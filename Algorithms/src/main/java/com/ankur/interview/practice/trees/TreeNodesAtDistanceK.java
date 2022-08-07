package com.ankur.interview.practice.trees;

import java.util.*;

public class TreeNodesAtDistanceK {
  /*
  /
   */
  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
    Map<Integer, BinaryTree> nodeParent = new HashMap<>();
    getParentsOfNodes(tree, nodeParent, null);
    BinaryTree targetNode = getNodeFromValue(tree, target, nodeParent);

    // Write your code here.
    return bfsForNodesAtDistanceK(nodeParent, targetNode, k);
  }

  private ArrayList<Integer> bfsForNodesAtDistanceK(Map<Integer, BinaryTree> nodeParent, BinaryTree targetNode, int k) {
    Deque<Pair<BinaryTree, Integer>> queue = new ArrayDeque<>();
    queue.add(new Pair<>(targetNode, 0));
    HashSet<Integer> visited = new HashSet<>();
    visited.add(targetNode.value);
    while (queue.size() > 0) {
      Pair<BinaryTree, Integer> vals = queue.poll();
      BinaryTree node = vals.first;
      int distanceFromNode = vals.second;
      if (distanceFromNode == k) {
        ArrayList<Integer> nodes = new ArrayList<>();
        for (Pair<BinaryTree, Integer> pair : queue) {
          nodes.add(pair.first.value);
        }
        nodes.add(node.value);
        return nodes;
      }
      List<BinaryTree> connectedNodes = new ArrayList<>();
      connectedNodes.add(node.left);
      connectedNodes.add(node.right);
      connectedNodes.add(nodeParent.get(node.value));

      for (BinaryTree item : connectedNodes) {
        if (item == null)
          continue;
        if (visited.contains(item.value))
          continue;
        visited.add(item.value);
        queue.add(new Pair<BinaryTree, Integer>(item, distanceFromNode + 1));
      }
    }
    return new ArrayList<>();
  }

  static class Pair<U, V> {
    public final U first;
    public final V second;

    Pair(U first, V second) {
      this.first = first;
      this.second = second;
    }
  }

  private BinaryTree getNodeFromValue(BinaryTree tree, int target, Map<Integer, BinaryTree> nodeParent) {
    // 3 possibilities
    if (tree.value == target) {
      return tree;
    }
    BinaryTree parent = nodeParent.get(target);
    //we dont know it was left child or right child
    if (parent.left != null && parent.left.value == target) {
      return parent.left;
    } else
      return parent.right;
  }

  private void getParentsOfNodes(BinaryTree root, Map<Integer, BinaryTree> nodeParent, BinaryTree parent) {
    if (root != null) {
      nodeParent.put(root.value, parent);
      getParentsOfNodes(root.left, nodeParent, root);
      getParentsOfNodes(root.right, nodeParent, root);
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  /*
  /=====================================================================
  Recursive solution
  if the target value equals the value of any node then we will measure distance from node to root and
  1) there are nodes k distance below in subtree
  2) there are nodes k distance on other side of root
   */
  public ArrayList<Integer> findNodesDistanceKRecursive(BinaryTree tree, int target, int k) {
    ArrayList<Integer> nodesDistanceK = new ArrayList<>();
    findDistanceFromNodeToTarget(tree, target, k, nodesDistanceK);
    return nodesDistanceK;
  }

  private int findDistanceFromNodeToTarget(BinaryTree root, int target, int k, ArrayList<Integer> nodesDistanceK) {
    if (root == null) {
      return -1;
    }

    if (root.value == target) {
      // we will go down tree
      addSubtreeNodeAtDistanceK(root, 0, k, nodesDistanceK);
      return 1;
    }

    int leftDistance = findDistanceFromNodeToTarget(root.left, target, k, nodesDistanceK);
    int rightDistance = findDistanceFromNodeToTarget(root.right, target, k, nodesDistanceK);
    if (leftDistance == k || rightDistance == k) nodesDistanceK.add(root.value);
    // if this is not left leaf node
    if (leftDistance != -1) {
      addSubtreeNodeAtDistanceK(root.right, leftDistance + 1, k, nodesDistanceK);
      return leftDistance + 1;
    }
    // if this is not right leaf node
    if (rightDistance != -1) {
      addSubtreeNodeAtDistanceK(root.left, rightDistance + 1, k, nodesDistanceK);
     // we went down right so plus one
      return rightDistance + 1;
    }
    return -1;
  }

  private void addSubtreeNodeAtDistanceK(BinaryTree root, int distance, int k, ArrayList<Integer> nodesDistanceK) {
    if (root == null) {
      return;
    }
    if (distance == k) {
      nodesDistanceK.add(root.value);
    } else {
      addSubtreeNodeAtDistanceK(root.left, distance + 1, k, nodesDistanceK);
      addSubtreeNodeAtDistanceK(root.right, distance + 1, k, nodesDistanceK);
    }
  }
}

