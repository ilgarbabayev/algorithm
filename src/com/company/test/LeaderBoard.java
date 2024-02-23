package com.company.test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true

/*

An arcade game player wants to climb to the top of the leaderboard and track their ranking.
The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number,
and the next player(s) receive the immediately following ranking number.
Example
List<Integer> ranked_01 = List.of(100,90,90,80);
List<Integer> player_01 = List.of(70,80,105);


The ranked players will have ranks 1, 2, 2, and 3, respectively. If the player's scores are 70, 80 and 105,
their rankings after each game are 4, 3 and 1. Return [4,3,1]

 */

public class LeaderBoard {

  public static void main(String[] args) {
    List<Integer> ranked_01 = List.of(100,90,90,80);
    List<Integer> player_01 = List.of(70,80,105);

    System.out.println(climbingLeaderboard(ranked_01, player_01));
  }

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    TreeMap<Integer, Integer> rankedTree = new TreeMap<>(Comparator.reverseOrder());
    int rank = 0;
    List<Integer> leaderBoard = new ArrayList<>();
    for (Integer rankScore : ranked) {
      if (rankedTree.get(rankScore) == null) {
        rank++;
      }
      rankedTree.put(rankScore, rank);
    }

    for (Integer playerScore : player) {
      Map.Entry<Integer, Integer> ceilingEntry = rankedTree.ceilingEntry(playerScore);
      Integer rankKey = rankedTree.get(playerScore);

      if (rankKey == null) {
        if (ceilingEntry == null) {
          leaderBoard.add(rank + 1);
        } else {
          leaderBoard.add(ceilingEntry.getValue());
        }
      } else {
        leaderBoard.add(rankKey);
      }
    }

    return leaderBoard;
  }
}
