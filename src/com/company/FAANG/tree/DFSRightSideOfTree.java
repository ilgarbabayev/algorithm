package com.company.FAANG.tree;

import java.util.ArrayList;
import java.util.List;

public class DFSRightSideOfTree {

  /*

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

    public static void main(String[] args) {
        TreeNode tree1 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        null, new TreeNode(7,
                                        new TreeNode(8), null)), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6)));
        List<Integer> result = rightSideView(tree1);
        System.out.println(result);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preOrder(root, result, 1);
        return result;
    }

    private static void preOrder(TreeNode node, List<Integer> result, int level) {

        if (result.size() < level) {
            result.add(node.val);
        }

        if (node.right != null) {
            preOrder(node.right, result, level + 1);
        }

        if (node.left != null) {
            preOrder(node.left, result, level + 1);
        }
    }
}


