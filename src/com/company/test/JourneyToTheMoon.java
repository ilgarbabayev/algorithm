package com.company.test;

/*
The member states of the UN are planning to send  people to the moon. They want them to be from different countries.
You will be given a list of pairs of astronaut ID's.
Each pair is made of astronauts from the same country.
Determine how many pairs of astronauts from different countries they can choose from.

Function Description

Complete the journeyToMoon function in the editor below.

journeyToMoon has the following parameter(s):

int n: the number of astronauts
int astronaut[p][2]: each element astronaut[i] is a 2 element array that represents the ID's of two astronauts from the same country
Returns
- int: the number of valid pairs

Input Format

The first line contains two integers n and p, the number of astronauts and the number of pairs.
Each of the next p lines contains 2 space-separated integers denoting astronaut ID's of two who share the same nationality.

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JourneyToTheMoon {

  public static void main(String[] args) {
    int[][] arrays = new int[][] {{0, 1}, {2, 3}, {1, 4}};
    var count = returnCount(6, arrays);
    System.out.println(count);
  }

  private static int returnCount(int size, int[]... arrays) {
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      list.add(new ArrayList<>());
    }

    for (int[] array : arrays) {
      list.get(array[0]).add(array[1]);
      list.get(array[1]).add(array[0]);
    }

    List<Integer> countries = new ArrayList<>();
    boolean[] isMarked = new boolean[size];

    for (int i = 0; i < size; i++) {
      Queue<Integer> queue = new LinkedList<>();

      int countrySize = 0;

      queue.offer(i);

      while (!queue.isEmpty()) {
        int aust = queue.poll();
        if (!isMarked[aust]) {
          queue.addAll(list.get(aust));
          isMarked[aust] = true;
          countrySize++;
        }
      }
      if (countrySize > 0) {
        countries.add(countrySize);
      }
    }

    int ways = 0;
    int num = size;

    for (int countrySize : countries) {
      ways += countrySize * (num -= countrySize);
    }

    return ways;
  }
}
