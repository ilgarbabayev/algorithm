package com.company.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/*
Given an undirected graph and a starting node, determine the lengths of the shortest paths from the starting node to all other nodes in the graph.
If a node is unreachable, its distance is -1. Nodes will be numbered consecutively from 1 to n, and edges will have varying distances or lengths.
 */
public class DijkstraShortestReach22 {

  public static void main(String[] args) {
    //    int n = 5;
    //    int s = 1;
    //    var edges = List.of(
    //        List.of(1,2,5),
    //        List.of(2,3,6),
    //        List.of(3,4,2),
    //        List.of(1,3,15));

    int n = 4;
    int s = 1;
    var edges = List.of(
        List.of(1,2,24),
        List.of(1,4,20),
        List.of(3,1,3),
        List.of(4,3,12));

    var result = shortestReach(n, edges, s);

    System.out.println(result);

  }

  public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
    List<Map<Integer, Integer>> nodes = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      nodes.add(new HashMap<>());
    }

    edges.forEach(edge -> {
      var x = edge.get(0);
      var y = edge.get(1);
      var len = edge.get(2);

      var xMembers = nodes.get(x - 1);
      var yMembers = nodes.get(y - 1);

      boolean addMembers = false;

      if (xMembers.getOrDefault(y, Integer.MAX_VALUE) > len) {
        xMembers.put(y, len);
        addMembers = true;
      }

      if (yMembers.getOrDefault(x, Integer.MAX_VALUE) > len) {
        yMembers.put(x, len);
        addMembers = true;
      }

      if (addMembers) {

        var startMembers = nodes.get(s - 1);
        var newMembers = new HashMap<>(startMembers);
        startMembers.keySet().forEach(k -> addMembers(nodes.get(k - 1), newMembers, k, s));
        nodes.set(s - 1, newMembers);
      }
    });

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (i + 1 == s) continue;
      result.add(nodes.get(s - 1).getOrDefault(i + 1, -1));
    }

    return result;
  }

  private static void addMembers(Map<Integer, Integer> from, Map<Integer, Integer> to, int fromNode, int toNode) {
    var length = to.getOrDefault(fromNode, 0);
    from.forEach((k, v) -> {
      if (k != toNode && to.getOrDefault(k, Integer.MAX_VALUE) > v + length) {
        to.put(k, v + length);
      }
    });
  }

}
