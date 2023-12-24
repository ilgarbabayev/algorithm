package com.company.FAANG.linkedList;

public class FlattenedDoublyLinkedList {
  public static void main(String[] args) {
    Node node_1 = new Node(1);
    node_1.next = new Node(2);
    node_1.next.next = new Node(3);
    node_1.next.next.next = new Node(4);
    node_1.next.next.next.next = new Node(5);
    node_1.next.next.next.next.next = new Node(6);

    Node node_2 = new Node(7);
    node_2.next = new Node(8);
    node_2.next.next = new Node(9);
    node_2.next.next.next = new Node(10);

    Node node_3 = new Node(11);
    node_3.next = new Node(12);

    node_1.next.next.child = node_2;
    node_2.next.child = node_3;

    Node result = flatten(node_1);

    System.out.println(result);

  }

  public static Node flatten(Node head) {
    if (head == null) return head;

    Node currNode = head;

    while (currNode != null) {
      if (currNode.child == null) {
        currNode = currNode.next;
      } else {
        Node tail = currNode.child;
        while (tail.next != null) {
          tail = tail.next;
        }
        tail.next = currNode.next;
        if (tail.next != null) {
          tail.next.prev = tail;
        }

        currNode.next = currNode.child;
        currNode.next.prev = currNode;
        currNode.child = null;
      }
    }

    return head;
  }


  static class Node {
    Node () {}
    Node (int val) {
      this.val = val;
    }
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("[").append(this.val).append("]");
      Node i = next;
      while (i != null) {
        builder.append(" -> ").append(i.val);
        i = i.next;
      }
      return builder.toString();
    }
  }
}


