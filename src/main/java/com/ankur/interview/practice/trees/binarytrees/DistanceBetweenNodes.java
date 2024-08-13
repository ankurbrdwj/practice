/**
 *
 */
package com.ankur.interview.practice.trees.binarytrees;

/**
 * @author ankurbrdwj
 *
 */
public class DistanceBetweenNodes {

    /**
     *
     */
    public DistanceBetweenNodes() {
        // TODO Auto-generated constructor stub
    }

    public int findLevel(Node root, Node n, int l) {
        if (root == null)
            return -1;
        if (root.data == n.data)
            return l;
        l = findLevel(root, root.left, l + 1);

        return l != -1 ? l : findLevel(root, root.right, l + 1);
    }

    private int distanceBetweenNodes(Node root, Node n1, Node n2) {
        int d1 = -1;
        int d2 = -1;
        int dist = 0;
        Node lca = distanceBetweenNodes(root, n1, n2, d1, d2, dist, 1);
        if (d1 != -1 && d2 != -1)//They  both go through root
            return dist;
        if (d1 != -1) {
            dist = findLevel(lca, n2, 0);
            return dist;
        }
        if (d2 != -1) {
            dist = findLevel(lca, n1, 0);
            return dist;
        }
        return -1;
    }

    private Node distanceBetweenNodes(Node root, Node n1, Node n2, int d1, int d2, int dist, int level) {
        // TODO Auto-generated method stub
        if (root == null)
            return null;
        if (root.data == n1.data) {
            d1 = level;
            return root;
        }
        if (root.data == n2.data) {
            d2 = level;
            return root;
        }
        Node left = distanceBetweenNodes(root.left, n1, n2, d1, d2, dist, level + 1);
        Node right = distanceBetweenNodes(root.right, n1, n2, d1, d2, dist, level + 1);

        if (left != null && right != null) {
            dist = d1 + d2 - 2 * level;
            return root;
        }

        return left != null ? left : right;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        DistanceBetweenNodes dbn = new DistanceBetweenNodes();
        int result = dbn.distanceBetweenNodes(root, root.left.left, root.right.left);
        System.out.println(result);
    }

}
