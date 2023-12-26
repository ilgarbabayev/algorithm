package com.company.FAANG.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RotOranges {
  private static int n;
  private static int m;

  public static void main(String[] args) {
    int[][] arr = new int[][] {
        {1,1,0,0,0},
        {2,1,0,0,0},
        {0,0,0,1,2},
        {0,0,0,0,1}
    };

    int[][] arr2 = new int[][] {
        {1,1,0,0,0},
        {2,1,0,0,0},
        {0,0,0,1,2},
        {0,1,0,0,1}
    };

    int[][] arr3 = new int[][] {
        {1,1,1,0,0},
        {1,1,1,0,0},
        {2,1,1,0,0},
        {0,1,1,1,2},
        {0,1,0,0,1}
    };

    System.out.println(orangesRotting(arr));
    System.out.println(orangesRotting(arr2));
    System.out.println(orangesRotting(arr3));
  }

  public static int orangesRotting(int[][] grid) {

    if (grid.length == 0 || grid[0].length == 0) {
      return -1;
    }

    Queue<List<Integer>> queue = new LinkedList<>();
    int oranges = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          oranges++;
        }
        if (grid[i][j] == 2) {
          queue.add(List.of(i,j));
        }
      }
    }

    if (queue.isEmpty() && oranges == 0) {
      return 0;
    }

    if (queue.isEmpty()) {
      return  -1;
    }

    if (oranges == 0) {
      return 0;
    }


    int count = 0;
    boolean isCount;

    while (!queue.isEmpty()) {
      isCount = false;
      for (int i = queue.size(); i > 0; i--) {
        List<Integer> curr = queue.poll();
        if (markArray(grid, curr.get(0) - 1, curr.get(1))) {
          queue.add(List.of( curr.get(0) - 1, curr.get(1)));
          oranges--;
          isCount = true;
        }

        if (markArray(grid, curr.get(0), curr.get(1) + 1)) {
          queue.add(List.of( curr.get(0), curr.get(1) + 1));
          oranges--;
          isCount = true;
        }

        if (markArray(grid, curr.get(0) + 1, curr.get(1))) {
          queue.add(List.of( curr.get(0) + 1, curr.get(1)));
          oranges--;
          isCount = true;
        }

        if (markArray(grid, curr.get(0), curr.get(1) - 1)) {
          queue.add(List.of( curr.get(0), curr.get(1) - 1));
          oranges--;
          isCount = true;
        }
      }

      if (isCount) {
        count++;
      }
    }

    if (oranges > 0) {
      return  -1;
    }

    return count;
  }

  private static boolean markArray(int[][] grid, int x, int y) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
      return false;
    }

    if (grid[x][y] == 1) {
      grid[x][y] = 2;
      return true;
    }

    return false;
  }
}
