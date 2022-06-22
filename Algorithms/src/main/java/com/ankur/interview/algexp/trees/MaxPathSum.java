package com.ankur.interview.algexp.trees;

public class MaxPathSum {
    // this will calculate maximum path sum of each node in current recursion and return max_all finally
    static int result = Integer.MIN_VALUE;
    static ListNode node;
    private static int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        result = Math.max(result, root.value + left + right);
        System.out.println("Current Root : " +root.value+ " and Current Max path sum: "+result);
        int max=Math.max(left, right);
       /* if(node==null){
            node = new ListNode();
            node.value=max;
        }else{
            node.next = new ListNode();
            node.next.value=max;
        }*/
        return root.value + max;
    }


    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
 static class ListNode {
        int value;
        ListNode next;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
        ListNode runner = node;
        while(runner!=null){
            System.out.printf("%d --> ",runner.value);
            runner=runner.next;
        }
    }
}
