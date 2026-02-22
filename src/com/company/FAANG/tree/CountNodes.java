package com.company.FAANG.tree;

/*

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

      1
    /   \
   2     3
  /\    /
 4  5  6

*/

public class CountNodes {
    public static void main(String[] args) {
        TreeNode tree1 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4), new TreeNode(5)),
                        new TreeNode(3, new TreeNode(6), null));

        System.out.println(countNodes(tree1));

    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int ln = countNodes(root.left);
        int rn = countNodes(root.right);
        return ln + rn + 1;
    }
}
