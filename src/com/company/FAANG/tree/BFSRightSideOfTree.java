package com.company.FAANG.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSRightSideOfTree {

  public static void main(String[] args) {
    TreeNode tree1 =
        new TreeNode(1,
                     new TreeNode(2,
                                  new TreeNode(4,
                                               null, new TreeNode(7,
                                                                  new TreeNode(8), null)), new TreeNode(5)),       new TreeNode(3, null, new TreeNode(6)));
    List<Integer> result = rightSideView(tree1);
    System.out.println(result);
  }

  public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> arr = new ArrayList<>();

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      for (int i = queue.size(); i > 0; i--) {
        TreeNode node = queue.poll();

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
        if (i == 1) {
          arr.add(node.val);
        }
      }
    }

    return arr;
  }
}


