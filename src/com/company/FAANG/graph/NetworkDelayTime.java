package com.company.FAANG.graph;

/*
You are given a network of n nodes, labeled from 1 to n. You are also given times,
a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
If it is impossible for all the n nodes to receive the signal, return -1.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {

  public static void main(String[] args) {
    int n1 = 4;
    int k1 = 2;
    int[][] times1 = new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};

    int n2 = 2;
    int k2 = 1;
    int[][] times2 = new int[][] {{1, 2, 1}};

    int n3 = 2;
    int k3 = 2;
    int[][] times3 = new int[][] {{1, 2, 1}};

    int n4 = 2;
    int k4 = 2;
    int[][] times4 = new int[][] {{1, 2, 1}, {2, 1, 3}};

    int n5 = 3;
    int k5 = 1;
    int[][] times5 = new int[][] {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};

    int n6 = 5;
    int k6 = 5;
    int[][] times6 =
        new int[][] {{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15},
            {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}};

//    System.out.println(networkDelayTime(times1, n1, k1));
//    System.out.println(networkDelayTime(times2, n2, k2));
//    System.out.println(networkDelayTime(times3, n3, k3));
//    System.out.println(networkDelayTime(times4, n4, k4));
//    System.out.println(networkDelayTime(times5, n5, k5));
    System.out.println(networkDelayTime(times6, n6, k6));
  }

  public static int networkDelayTime(int[][] times, int n, int k) {
    int[] accumTime = new int[n + 1];
    Arrays.fill(accumTime, Integer.MAX_VALUE);

    Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();

    for (int[] part : times) {
      adj.putIfAbsent(part[0], new HashMap<>());
      adj.get(part[0]).put(part[1], part[2]);
    }

    Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    queue.add(new int[] {k, 0});
    accumTime[k] = 0;

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();

      int currNode = curr[0];

      for (Map.Entry<Integer, Integer> next : adj.getOrDefault(currNode, new HashMap<>()).entrySet()) {
        Integer nextNode = next.getKey();
        Integer nextWeight = next.getValue();

        int i2 = accumTime[currNode] + nextWeight;

        if (i2 >= accumTime[nextNode]) {
          continue;
        }
        accumTime[nextNode] = i2;
        queue.add(new int[] {nextNode, nextWeight});
      }
    }

    int maxTime = 0;

    for (int x = 1; x < accumTime.length; x++) {
      if (accumTime[x] == Integer.MAX_VALUE) {
        return -1;
      }
      maxTime = Math.max(maxTime, accumTime[x]);
    }
    return maxTime;
  }
}
