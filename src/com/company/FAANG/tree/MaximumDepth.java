package com.company.FAANG.tree;

/*

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepth {
  public static void main(String[] args) {

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
