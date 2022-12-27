package com.company.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given a graph which consists of several edges connecting its nodes, find a subgraph of the given graph with the following properties:

The subgraph contains all the nodes present in the original graph.
The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
It is also required that there is exactly one, exclusive path between any two nodes of the subgraph.
One specific node  is fixed as the starting point of finding the subgraph using Prim's Algorithm.
Find the total weight or the sum of all edges in the subgraph.
 */
public class PrimsSpecialSubtree {

  public static void main(String[] args) {
//    int n = 5;
//    int start = 1;
//    var edges = List.of(List.of(1,2,3),List.of(1,3,4),List.of(4,2,6),List.of(5,2,2),List.of(2,3,5),List.of(3,5,7));
//
    int n = 5;
    int start = 1;
    var edges = List.of(List.of(1,2,2),List.of(2,3,3),List.of(3,5,7),List.of(1,4,6),List.of(2,4,8),List.of(2,5,5), List.of(4,5,9));


//    int n = 5;
//    int start = 2;
//    var edges = List.of(List.of(1,2,20),List.of(1,3,50),List.of(1,4,70),List.of(1,5,90),List.of(2,3,30),List.of(3,4,40), List.of(4,5,60));

    var sum = prims(n, edges, start);

    System.out.println(sum);

  }

  public static int prims(int n, List<List<Integer>> edges, int start) {
    List<Queue<WeightGraph>> list = new ArrayList<>();
    int[] weight = new int[n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      list.add(new PriorityQueue<>(Comparator.comparing(a -> a.length)));
      weight[i] = Integer.MAX_VALUE;
    }

    edges.forEach(edge -> {
      var xMembers = list.get(edge.get(0) - 1);
      var yMembers = list.get(edge.get(1) - 1);

      xMembers.add(new WeightGraph(edge.get(1), edge.get(2)));
      yMembers.add(new WeightGraph(edge.get(0), edge.get(2)));
    });

    Queue<WeightGraph> queue = new PriorityQueue<>(Comparator.comparing(a -> a.length));
    queue.addAll(list.get(start - 1));

    while (!queue.isEmpty()) {
      populate(list, queue, weight, visited, start);
    }

    int sum = 0;

    for (int i = 0; i < n; i++) {
      if (i != start - 1) {
        sum += weight[i];
      }
    }

    return sum;
  }

  private static void populate(List<Queue<WeightGraph>> list, Queue<WeightGraph> queue, int[] weight, boolean[] visited, int start) {
    var graph = queue.poll();

    if (graph.to != start && !visited[graph.to - 1] && weight[graph.to - 1] > graph.length) {
      visited[graph.to - 1] = true;
      weight[graph.to - 1] = graph.length;
      queue.addAll(list.get(graph.to - 1));
    }
  }

  static class WeightGraph {
    int to;
    int length;

    public WeightGraph(int to, int length) {
      this.to = to;
      this.length = length;
    }
  }
}

