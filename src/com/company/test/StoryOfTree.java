package com.company.test;

import java.math.BigInteger;
import java.util.List;

/*
Given a directed weighted graph where weight indicates distance, for each query, determine the length of the shortest path between nodes.
There may be many queries, so efficiency counts.
 */
public class StoryOfTree {
  public static void main(String[] args) {
    var n = 4;
    var edges = List.of(List.of(1,2),List.of(1,3),List.of(3,4));
    var k = 2;
    var guesses = List.of(List.of(1,2), List.of(3,4));

//    var n = 3;
//    var edges = List.of(List.of(1,2),List.of(1,3));
//    var k = 2;
//    var guesses = List.of(List.of(1,2), List.of(1,3));

    var result = storyOfATree(n, edges, k, guesses);
    System.out.println(result);
  }

  public static String storyOfATree(int n, List<List<Integer>> edges, int k, List<List<Integer>> guesses) {
    boolean[][] guessArr = new boolean[n + 1][n + 1];

    guesses.forEach(guess -> guessArr[guess.get(0)][guess.get(1)] = true);

    boolean[][] adjArr = new boolean[n + 1][n + 1];

    edges.forEach(edge -> {
      adjArr[edge.get(0)][edge.get(1)] = true;
      adjArr[edge.get(1)][edge.get(0)] = true;
    });

    var sum = 0;
    var matches = false;

    for (int i = 1; i <= n; i++) {
      var visited = new boolean[n + 1];

      for (int j = 1; j <= n; j++) {
        if (!visited[j]) {
          visited[j] = true;
          if (adjArr[i][j] && guessArr[i][j]) {
            matches = true;
          }
        }
      }

      visited[i] = true;

      if (matches) {
        sum++;
        matches = false;
      }
    }

    var gcd = BigInteger.valueOf(sum).gcd(BigInteger.valueOf(n)).intValue();

    return sum / gcd + "/" + n / gcd;

  }
}
