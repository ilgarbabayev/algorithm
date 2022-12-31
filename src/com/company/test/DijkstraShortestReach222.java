package com.company.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import com.company.util.DataConverter;

/*
Given an undirected graph and a starting node, determine the lengths of the shortest paths from the starting node to all other nodes in the graph.
If a node is unreachable, its distance is -1. Nodes will be numbered consecutively from 1 to n, and edges will have varying distances or lengths.
 */
public class DijkstraShortestReach222 {

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

    //    int n = 4;
    //    int s = 1;
    //    var edges = List.of(
    //        List.of(1,2,24),
    //        List.of(1,4,20),
    //        List.of(3,1,3),
    //        List.of(4,3,12));

    //    int n = 5;
    //    int s = 1;
    //    var edges = List.of(
    //        List.of(3,1,3),
    //        List.of(5,4,3),
    //        List.of(4,3,12),
    //        List.of(1,4,20),
    //        List.of(1,2,24),
    //        List.of(3,5,3));

    //    int n = 5;
    //    int s = 1;
    //    var edges = List.of(
    //        List.of(1,2,2),
    //        List.of(2,3,3),
    //        List.of(1,4,6),
    //        List.of(3,5,7),
    //        List.of(2,4,8),
    //        List.of(2,5,5),
    //        List.of(4,5,9));

    //    var result = shortestReach(n, edges, s);
    //
    //    System.out.println("-------------------------");
    //    System.out.println(result);

    var listList = DataConverter.getIntList("djikstra_input.txt").stream().skip(1).collect(Collectors.toList());
    var outputList = new ArrayList<>(DataConverter.getIntList("djikstra_output.txt"));

    var end = false;
    var nSize = 0;
    var start = 0;
    var counter = 0;
    List<List<Integer>> egs = new ArrayList<>();

    List<Integer> rslt;

    for (List<Integer> list : listList) {
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
  }

  public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
    List<Queue<WeightGraph>> list = new ArrayList<>();
    int[] weight = new int[n];
    boolean[] visited = new boolean[n];
    //    int[] parent = new int[n];

    for (int i = 0; i < n; i++) {
      list.add(new PriorityQueue<>(Comparator.comparing(a -> a.length)));
      weight[i] = Integer.MAX_VALUE;
    }
    weight[s - 1] = 0;

    edges.forEach(edge -> {
      var xMembers = list.get(edge.get(0) - 1);
      var yMembers = list.get(edge.get(1) - 1);

      xMembers.add(new WeightGraph(edge.get(0), edge.get(1), edge.get(2)));
      yMembers.add(new WeightGraph(edge.get(1), edge.get(0), edge.get(2)));
    });

    Queue<WeightGraph> queue = new PriorityQueue<>(Comparator.comparing(a -> a.length));
    queue.addAll(list.get(s - 1));

    while (!queue.isEmpty()) {
      populate(list, queue, weight, visited, s);
    }

    int sum = 0;
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (i != s - 1) {
        if (Integer.MAX_VALUE == weight[i]) {
          result.add(-1);
        } else {
          result.add(weight[i]);
        }
      }
    }

    return result;
  }

  private static void populate(List<Queue<WeightGraph>> list, Queue<WeightGraph> queue, int[] weight, boolean[] visited, int start) {
    var graph = queue.poll();

    if (graph.to != start && !visited[graph.to - 1] && weight[graph.to - 1] > graph.length + weight[graph.from - 1]) {
      visited[graph.to - 1] = true;
      weight[graph.to - 1] = graph.length + weight[graph.from - 1];
      queue.addAll(list.get(graph.to - 1));
    }
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
