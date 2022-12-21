package com.company.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
Given an undirected weighted connected graph, find the Really Special SubTree in it. The Really Special SubTree is defined as a subgraph consisting of all the nodes in the graph and:

There is only one exclusive path from a node to every other node.
The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
No cycles are formed
To create the Really Special SubTree, always pick the edge with smallest weight. Determine if including it will create a cycle. If so, ignore the edge. If there are edges of equal weight available:

Choose the edge that minimizes the sum u + v + wt where u and v are vertices and wt is the edge weight.
If there is still a collision, choose any of them.
Print the overall weight of the tree formed using the rules.
 */
public class KruskalSpecialSubtree {
  public static void main(String[] args) {
//    List<Integer> gFrom = List.of(1,1,1,1,2,3,4);
//    List<Integer> gTo = List.of(2,3,4,5,3,4,5);
//    List<Integer> gWeight = List.of(20,50,70,90,30,40,60);
//    int n = 4;

//    List<Integer> gFrom = List.of(1,1,4,2,3,3);
//    List<Integer> gTo = List.of(2,3,1,4,2,4);
//    List<Integer> gWeight = List.of(5,3,6,7,4,5);
//    int n = 5;

    List<Integer> gFrom = List.of(1,3,4,1,3);
    List<Integer> gTo = List.of(2,2,3,4,1);
    List<Integer> gWeight = List.of(1,150,99,100,200);
    int n = 4;

    System.out.println(kruskals(n, gFrom, gTo, gWeight));
  }

  public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {

    PriorityQueue<WeightGraph> queue = new PriorityQueue<>(Comparator.comparing(a -> a.weight));

    for (int i = 0; i < gFrom.size(); i++) {
      queue.add(new WeightGraph(gFrom.get(i), gTo.get(i), gWeight.get(i)));
    }

    List<Set<Integer>> nodes = new ArrayList<>();
    for (int i = 0; i < gNodes; i++) {
      var members = new HashSet<Integer>();
      members.add(i + 1);
      nodes.add(members);
    }

    int weight = 0;

    while (!queue.isEmpty()) {
      WeightGraph graph = queue.poll();
      var x = graph.from;
      var y = graph.to;
      var xNode = nodes.get(x - 1);
      var yNode = nodes.get(y - 1);
      if (!xNode.contains(y)) {
        weight += graph.weight;
        xNode.addAll(yNode);
      }

      xNode.forEach(m -> nodes.set(m - 1, xNode));

    }

    return weight;
  }

  static class WeightGraph {
    int from;
    int to;
    int weight;

    public WeightGraph(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }
}
