package com.company.search;

public class Tree {

  TreeNode root;

  public void insert(int value) {
    if (root == null) {
      root = new TreeNode(value);
    } else {
      root.insert(value);
    }
  }

  public TreeNode get(int value) {
    if (root != null) {
      return root.get(value);
    }
    return null;
  }

  public int min() {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    return root.min();
  }

  public int max() {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    return root.max();
  }

  public void traverseInOrder() {
    if (root != null) {
      root.traverseInOrder();
    }
  }

  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insert(25);
    tree.insert(20);
    tree.insert(15);
    tree.insert(27);
    tree.insert(30);
    tree.insert(29);
    tree.insert(26);
    tree.insert(22);
    tree.insert(31);

    System.out.println(tree);

    tree.traverseInOrder();
  }
}

class TreeNode {
  int value;
  TreeNode leftNode;
  TreeNode rightNode;

  public TreeNode(int value) {
    this.value = value;
  }

  public void insert(int newValue) {
    if (value == newValue) {
      return;
    }

    if (newValue < value) {
      if (leftNode == null) {
        leftNode = new TreeNode(newValue);
      } else {
        leftNode.insert(newValue);
      }
    } else {
      if (rightNode == null) {
        rightNode = new TreeNode(newValue);
      } else {
        rightNode.insert(newValue);
      }
    }
  }

  public TreeNode get(int value) {
    if (value == this.value) {
      return this;
    }

    if (value < this.value) {
      if (leftNode != null) {
        return leftNode.get(value);
      }
    } else {
      if (rightNode != null) {
        return rightNode.get(value);
      }
    }

    return null;
  }

  public int min() {
    if (leftNode == null) {
      return this.value;
    }

    return leftNode.min();
  }

  public int max() {
    if (rightNode == null) {
      return this.value;
    }

    return rightNode.max();
  }

  public void traverseInOrder() {
    if (leftNode != null) {
      leftNode.traverseInOrder();
    }
    System.out.print(value + ", ");

    if (rightNode != null) {
      rightNode.traverseInOrder();
    }
  }
}
