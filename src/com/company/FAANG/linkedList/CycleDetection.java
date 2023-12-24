package com.company.FAANG.linkedList;

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
