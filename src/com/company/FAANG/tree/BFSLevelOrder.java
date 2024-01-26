package com.company.FAANG.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

 */

public class BFSLevelOrder {

  public static void main(String[] args) {
    TreeNode tree1 =
        new TreeNode(3,
                     new TreeNode(6,
                                  new TreeNode(9,
                                               null, new TreeNode(5,
                                                                  new TreeNode(8), null)), new TreeNode(2)),       new TreeNode(1, null, new TreeNode(4)));
  List<List<Integer>> result = levelOrder(tree1);
  result.forEach(System.out::println);
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> arr = new ArrayList<>();

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> innerList = new ArrayList<>();
      for (int i = queue.size(); i > 0; i--) {
        TreeNode node = queue.poll();
        innerList.add(node.val);

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }
      arr.add(innerList);
    }

    return arr;
  }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
