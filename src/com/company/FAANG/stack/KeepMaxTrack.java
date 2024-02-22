package com.company.FAANG.stack;

import java.util.Deque;
import java.util.LinkedList;

public class KeepMaxTrack {

  public static void main(String[] args) {
    KeepMaxTrack keepMaxTrack = new KeepMaxTrack();
    keepMaxTrack.push(20);
    System.out.println(keepMaxTrack.getMax());
    keepMaxTrack.push(10);
    System.out.println(keepMaxTrack.getMax());
    keepMaxTrack.push(50);
    System.out.println(keepMaxTrack.getMax());
  }

  private Deque<Integer> mainStack = new LinkedList<>();
  private Deque<Integer> maxTrack = new LinkedList<>();

  public void push(Integer element) {
    mainStack.addFirst(element);

    if (mainStack.size() == 1) {
      maxTrack.addFirst(element);
      return;
    }

    if (maxTrack.peek() > element) {
      maxTrack.addFirst(maxTrack.peek());
    } else {
      maxTrack.addFirst(element);
    }
  }

  public void pop() {
    mainStack.pop();
    maxTrack.pop();
  }

  public Integer getMax() {
    return maxTrack.peek();
  }
}
