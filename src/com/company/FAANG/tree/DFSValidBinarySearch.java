package com.company.FAANG.tree;

/*
                           12
                       /       \
                     /           \
                   7               18
                 /   \         /        \
                5     13      16         25
                 \           / \        /  \
                  7         15  20    14    30
                 /              /\
                8              9  35
*/

public class DFSValidBinarySearch {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(1), null);

        System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(TreeNode node, long min, long max) {
        if (node.val <= min || node.val >= max) {
            return false;
        }

        boolean isLeftValid = true;
        boolean isRightValid = true;

        if (node.left != null) {
            isLeftValid = valid(node.left, min, node.val);
        }

        if (node.right != null) {
            isRightValid = valid(node.right, node.val, max);
        }

        return isLeftValid && isRightValid;
    }
}
