package com.company.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BfsShortestReach {

  public static void main(String[] args) {
    var list = bfs(5, 3, List.of(List.of(1,2), List.of(1,3), List.of(3,4)), 1);

    System.out.println(list);
  }

  public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    Graph graph = new Graph(n);

    edges.forEach(edge -> graph.addEdge(edge.get(0), edge.get(1)));

    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(s);

    int[] distance = new int[graph.adjList.size()];
    Arrays.fill(distance, -1);
    distance[s - 1] = 0;

    while (!queue.isEmpty()) {
      int node = queue.poll();

      for(int neighbor : graph.adjList.get(node - 1)) {
        if (distance[neighbor - 1] == -1) {
          distance[neighbor - 1] = distance[node - 1] + 6;
          queue.add(neighbor);
        }
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int j : distance) {
      if (j != 0) {
        result.add(j);
      }
    }

    return result;
  }


  static class Graph {
    ArrayList<LinkedList<Integer>> adjList;

    public Graph(int numNodes) {
      adjList = new ArrayList<>();
      for (int i = 0; i < numNodes; i++) {
        adjList.add(new LinkedList<>());
      }
    }

    public void addEdge(int a, int b) {
      adjList.get(a - 1).add(b);
      adjList.get(b - 1).add(a);
    }
  }
}
