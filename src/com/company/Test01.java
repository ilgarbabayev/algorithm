package com.company;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Semaphore;


public class Test01 {

  public static void main(String args[]) throws InterruptedException {
    ArrayDeque<String> list = new ArrayDeque<>();
    list.add("aaa");
    list.add("bbb");

    System.out.println(list.peekLast());
    System.out.println(list.pollLast());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(1);
    pq.peek();
    pq.poll();
  }

}

class Shared {
  static int count = 0;
}

class MyThread extends Thread {
  Semaphore sem;
  String threadName;

  public MyThread(Semaphore sem, String threadName) {
    super(threadName);
    this.sem = sem;
    this.threadName = threadName;
  }

  @Override
  public void run() {

    if (this.getName().equals("A")) {
      System.out.println("Starting " + threadName);
      try {
        Thread.sleep(10);
        System.out.println(threadName + " is waiting for a permit.");

        sem.acquire();

        System.out.println(threadName + " gets a permit.");

        for (int i = 0; i < 5; i++) {
          Shared.count++;
          System.out.println(threadName + ": " + Shared.count);

          Thread.sleep(10);
        }
      } catch (InterruptedException exc) {
        System.out.println(exc);
      }

      System.out.println(threadName + " releases the permit.");
      sem.release();
    } else {
      System.out.println("Starting " + threadName);
      try {
        System.out.println(threadName + " is waiting for a permit.");

        sem.acquire();

        System.out.println(threadName + " gets a permit.");

        for (int i = 0; i < 5; i++) {
          Shared.count--;
          System.out.println(threadName + ": " + Shared.count);

          Thread.sleep(10);
        }
      } catch (InterruptedException exc) {
        System.out.println(exc);
      }
      System.out.println(threadName + " releases the permit.");
      sem.release();
    }
  }
}

class SemaphoreDemo {
  public static void main(String args[]) throws InterruptedException {
    Semaphore sem = new Semaphore(1);

    MyThread mt1 = new MyThread(sem, "A");
    MyThread mt2 = new MyThread(sem, "B");

    mt2.start();
    mt1.start();

    mt1.join();
    mt2.join();

    System.out.println("count: " + Shared.count);
  }
}





