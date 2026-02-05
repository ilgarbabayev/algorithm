package com.company.FAANG.linkedList;

import java.util.LinkedList;
import java.util.List;

/*
* Given the head of a singly linked list and two integers left and right where left <= right,
*  reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
* Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

*/

public class Reverse {
  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);

    ListNode result = reverseBetween(node, 2, 4);

    System.out.println(result);
  }

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode start = head;
    ListNode currNode = head;

    int currPos = 1;

    while (currPos < left) {
      start = currNode;
      currNode = currNode.next;
      currPos++;
    }

    ListNode newList = null;
    ListNode tail = currNode;
    ListNode next;

    while (currPos >= left && currPos <= right) {
      next = currNode.next;
      currNode.next = newList;
      newList = currNode;
      currNode = next;
      currPos++;
    }

    start.next = newList;
    tail.next = currNode;

    if (left > 1) {
      return head;
    } else {
      return newList;
    }
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[").append(val).append("]");
    ListNode i = next;
    if (i != null) {
      builder.append(" -> ").append(i.val);
    }
//    while (i != null) {
//      builder.append(" -> ").append(i.val);
//      i = i.next;
//    }

    return builder.toString();
  }
}
