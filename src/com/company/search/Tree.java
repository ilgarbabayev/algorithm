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

  public void delete(int value) {
    root = delete(root, value);
  }

  private TreeNode delete(TreeNode subtreeNode, int value) {
    if (subtreeNode == null) {
      return null;
    }

    if (value < subtreeNode.value) {
      subtreeNode.leftNode = delete(subtreeNode.leftNode, value);
    } else if (value > subtreeNode.value) {
      subtreeNode.rightNode = delete(subtreeNode.rightNode, value);
    } else {
      if (subtreeNode.leftNode == null) {
        return subtreeNode.rightNode;
      } else if (subtreeNode.rightNode == null) {
        return subtreeNode.leftNode;
      } else {
        subtreeNode.value = subtreeNode.rightNode.min();
        subtreeNode.rightNode = delete(subtreeNode.rightNode, subtreeNode.value);
      }
    }

    return subtreeNode;
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

  public void traversePreOrder() {
    if (root != null) {
      root.traversePreOrder();
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

    System.out.println("In Order");
    tree.traverseInOrder();
    System.out.println();

    System.out.println("Pre Order");
    tree.traversePreOrder();
    System.out.println();

    System.out.println(tree.min());
    System.out.println(tree.max());

    tree.delete(27);
    tree.traverseInOrder();
    System.out.println();

    tree.delete(30);
    tree.traverseInOrder();
    System.out.println();
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

  public void traversePreOrder() {

    System.out.print(value + ", ");

    if (leftNode != null) {
      leftNode.traversePreOrder();
    }

    if (rightNode != null) {
      rightNode.traversePreOrder();
    }
  }
}
