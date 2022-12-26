package com.company.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
Markov takes out his Snakes and Ladders game, stares at the board and wonders: "If I can always roll the die to whatever number I want, what would
be the least number of rolls to reach the destination?"

Rules The game is played with a cubic die of 6 faces numbered 1 to 6.

1) Starting from square 1, land on square 100 with the exact roll of the die. If moving the number rolled would place the player beyond square 100,
 no move is made.

2) If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.

3) If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.
 */
public class SnakesAndLadders {
  public static void main(String[] args) {
//    var ladders = getModifiable(List.of(List.of(32, 62), List.of(42, 68), List.of(12, 98)));
//    var snakes = getModifiable(List.of(List.of(95, 13), List.of(97, 25), List.of(93, 37), List.of(79, 27), List.of(75, 19), List.of(49, 47), List.of(67, 17)));

//    var ladders = getModifiable(List.of(List.of(20, 60), List.of(10, 40), List.of(50, 80), List.of(55, 95)));
//    var snakes = getModifiable(List.of(List.of(95, 13), List.of(97, 25), List.of(93, 37), List.of(79, 27), List.of(75, 19), List.of(49, 47), List.of(67, 17)));

//    var ladders = getModifiable(List.of(List.of(15, 90), List.of(10, 40), List.of(50, 90)));
//    var snakes = getModifiable(List.of(List.of(94, 13), List.of(97, 25), List.of(93, 37), List.of(79, 27), List.of(75, 19), List.of(49, 47), List.of(67, 17)));

    var ladders = getModifiable(List.of(List.of(3, 54), List.of(37, 100)));
    var snakes = getModifiable(List.of(List.of(56, 33)));

    var result = quickestWayUp(ladders, snakes);

    System.out.println(result);
  }

  private static List<List<Integer>> getModifiable(List<List<Integer>> list) {
    return list.stream().map(ArrayList::new).collect(Collectors.toList());
  }

  public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
    TreeMap<Integer, Rating> map = new TreeMap<>();

    var lSorted = ladders.stream().map(list -> new Ladder(list.get(0), list.get(1))).sorted(Comparator.comparing(a -> a.start)).collect(
        Collectors.toList());

    var snakeStart = snakes.stream().map(list -> list.get(0)).collect(Collectors.toSet());

    for (int i = lSorted.size() - 1; i >= 0; i--) {
      buildWay(lSorted.get(i), map, snakeStart);
    }

    return map.values().stream().min(Comparator.comparing(a -> a.overall)).orElseGet(() -> new Rating(0, calculateSteps(1,100, snakeStart))).overall;
  }

  private static void buildWay(Ladder ladder, TreeMap<Integer, Rating> map, Set<Integer> snakes) {
    int end = ladder.end;
    int steps = calculateSteps(end,100, snakes);
    var next = map.higherKey(end);

    while (next != null) {
      var tempSteps = calculateSteps(end, next, snakes) + map.get(next).stepsAfter;
      if (tempSteps < steps) {
        steps = tempSteps;
      }
      next = map.higherKey(next);
    }

    var overall = steps + calculateSteps(1, ladder.start, snakes);

    map.put(ladder.start, new Rating(steps, overall));
  }

  private static int calculateSteps(int start, int end, Set<Integer> snakes) {
    int steps = 0;
    while (start < end) {
      int jump = 6;
      while (snakes.contains(start + jump)) {
        jump--;
      }
      start += jump;
      steps++;
    }

    return steps;
  }

  static class Ladder {
    int start;
    int end;
    int length;

    public Ladder(int start, int end) {
      this.start = start;
      this.end = end;
      this.length = end - start;
    }
  }

  static class Rating {
    int stepsAfter;
    int overall;

    public Rating(int stepsAfter, int overall) {
      this.stepsAfter = stepsAfter;
      this.overall = overall;
    }
  }
}
