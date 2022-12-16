package com.company.test;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given a tree (a simple connected graph with no cycles).
Find the maximum number of edges you can remove from the tree to get a forest
such that each connected component of the forest contains an even number of nodes.
 */
public class EvenTree {

  public static void main(String[] args) {
    int nodeSize = 10;
    int edgeSize = 9;
    List<Integer> startNodes = List.of(2,3,4,5,6,7,8,9,10);
    List<Integer> endNodes = List.of(1,1,3,2,1,2,6,8,8);

    int count = evenForest(nodeSize, edgeSize, startNodes, endNodes);

    System.out.println(count);
  }

  static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
    Graph graph = new Graph(t_nodes);
    for (int i = 0; i < t_from.size(); i++) {
      graph.addEdge(t_from.get(i), t_to.get(i));
    }

    int[] result = decomposeTree(graph.nodes, 1);

    return result[1];

  }

  private static int[] decomposeTree(List<PriorityQueue<Integer>> nodes, Integer node) {
    int count = 0, edgesToRemove = 0;

    for(Integer childNode : nodes.get(node - 1)) {
      final int[] tmpMetadata = decomposeTree(nodes, childNode);
      edgesToRemove += tmpMetadata[1];

      if(tmpMetadata[0] % 2 == 0) {
        edgesToRemove++;
      } else {
        count += tmpMetadata[0];
      }
    }
    count++;

    return new int[]{count, edgesToRemove};
  }

  static class Graph {
    List<PriorityQueue<Integer>> nodes = new ArrayList<>();

    public Graph(int size) {
      for (int i = 0; i < size; i++) {
        nodes.add(new PriorityQueue<>());
      }
    }

    public void addEdge(int src, int dst) {
      if (src < dst) {
        nodes.get(src - 1).add(dst);
      } else {
        nodes.get(dst - 1).add(src);
      }
    }
  }
}
