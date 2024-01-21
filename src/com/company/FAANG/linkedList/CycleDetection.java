package com.company.FAANG.linkedList;

/*

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node
 that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
  Note that pos is not passed as a parameter.

 */

public class CycleDetection {
  public static void main(String[] args) {

  }


  public static ListNode detectCycle(ListNode head) {
    ListNode hare = head;
    ListNode tortoise = head;

    while (true) {
      hare = hare.next;
      tortoise = tortoise.next;

      if (hare == null || hare.next == null) {
        break;
      } else {
        hare = hare.next;
      }

      if (tortoise == hare) {
        break;
      }
    }

    ListNode p1 = head;
    ListNode p2 = tortoise;

    while (p1 != p2) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p1;
  }




  static  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
