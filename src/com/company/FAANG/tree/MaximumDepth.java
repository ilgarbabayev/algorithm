package com.company.FAANG.tree;

/*

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

     1
    /\
   2  3
  /\   \
 4  5   6
  \
   7
  /
 8


*/

public class MaximumDepth {
  public static void main(String[] args) {
    TreeNode tree1 =
        new TreeNode(1,
                     new TreeNode(2,
                                  new TreeNode(4,
                                               null, new TreeNode(7,
                                                                  new TreeNode(8), null)), new TreeNode(5)),       new TreeNode(3, null, new TreeNode(6)));

    System.out.println(maxDepth(tree1));

  }

  public static int maxDepth(TreeNode root) {
    // Base Condition
    if(root == null) return 0;
    // Hypothesis
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    // Induction
    return Math.max(left, right) + 1;
  }
}
