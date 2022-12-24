package com.company.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.company.util.DataConverter;

/*
Given an undirected graph and a starting node, determine the lengths of the shortest paths from the starting node to all other nodes in the graph.
If a node is unreachable, its distance is -1. Nodes will be numbered consecutively from 1 to n, and edges will have varying distances or lengths.
 */
public class DijkstraShortestReach2 {

  public static void main(String[] args) {
//    int n = 5;
//    int s = 1;
//    var edges = List.of(
//        List.of(1,2,5),
//        List.of(2,3,6),
//        List.of(3,4,2),
//        List.of(1,3,15));

//    int n = 4;
//    int s = 1;
//    var edges = List.of(
//        List.of(1,2,24),
//        List.of(1,4,20),
//        List.of(3,1,3),
//        List.of(4,3,12));

    int n = 5;
    int s = 1;
    var edges = List.of(
        List.of(3,1,3),
        List.of(5,4,3),
        List.of(4,3,12),
        List.of(1,4,20),
        List.of(1,2,24),
        List.of(3,5,3));

    var listList = DataConverter.getIntList("djikstra_input.txt").stream().skip(1).collect(Collectors.toList());
    var outputList = new ArrayList<>(DataConverter.getIntList("djikstra_output.txt"));

    var end = false;
    var nSize = 0;
    var start = 0;
    var counter = 0;
    List<List<Integer>> egs = new ArrayList<>();

    List<Integer> rslt;

    for(List<Integer> list : listList) {
      if (list.size() == 1) {
        start = list.get(0);
        end = true;
      } else if (list.size() == 2) {
        nSize = list.get(0);
      } else {
        var lst = List.of(list.get(0), list.get(1), list.get(2));
        egs.add(lst);
      }

      if (end) {
        rslt = shortestReach(nSize, egs, start);
        System.out.println(rslt);
        System.out.println(outputList.get(counter++));
        System.out.println(rslt.equals(outputList.get(counter - 1)));
        end = false;
      }
    }


//    var result = shortestReach(n, edges, s);

//    System.out.println("-------------------------");
//    System.out.println(result);

  }

  public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
    Queue<WeightGraph> queue = new PriorityQueue<>(Comparator.comparing(a -> a.length));

    edges.forEach(edge -> queue.add(new WeightGraph(edge.get(0), edge.get(1), edge.get(2))));

    List<Map<Integer, Integer>> nodes = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      nodes.add(new HashMap<>());
    }

    while (!queue.isEmpty()) {
      var graph = queue.poll();

      var x = graph.from;
      var y = graph.to;
      var len = graph.length;

      var xMembers = nodes.get(x - 1);
      var yMembers = nodes.get(y - 1);

      if (xMembers.getOrDefault(y, Integer.MAX_VALUE) > len) {
        xMembers.put(y, len);
      }

      if (yMembers.getOrDefault(x, Integer.MAX_VALUE) > len) {
        yMembers.put(x, len);
      }
    }

    var startMembers = nodes.get(s - 1);

    for (int i = 1; i <= n; i++) {
      if (i != s) {
        var len = startMembers.get(i);
        if (len != null) {
          var subMembers = nodes.get(i - 1);
          addMembers(subMembers, startMembers, i, s);

          var newLen = startMembers.get(i);
          if (!len.equals(newLen)) i--;
        }
      }
    }

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

  static class WeightGraph {
    int from;
    int to;
    int length;

    public WeightGraph(int from, int to, int length) {
      this.from = from;
      this.to = to;
      this.length = length;
    }
  }
}
