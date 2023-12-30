package com.company.FAANG.graph;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where
prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedulerTopologicalSort {

  public static void main(String[] args) {
    int numCourses = 6;
    int[][] prerequisites = new int[][] {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};

    int numCourses2 = 7;
    int[][] prerequisites2 = new int[][] {{0, 3}, {1, 0}, {2, 1}, {4, 5}, {6, 4}, {5, 6}};

    int numCourses3 = 4;
    int[][] prerequisites3 = new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

    System.out.println(canFinish(numCourses, prerequisites));
    System.out.println(canFinish(numCourses2, prerequisites2));
    System.out.println(canFinish(numCourses3, prerequisites3));
  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {

    int[] inDegree = new int[numCourses];
    List<Integer>[] adjList = new List[numCourses];
    Queue<Integer> queue = new LinkedList<>();
    int cnt = 0;

    for (int[] pair : prerequisites) {
      int preReq = pair[1];
      if (adjList[preReq] == null) {
        adjList[preReq] = new ArrayList<>();
      }

      int course = pair[0];
      adjList[preReq].add(course);
      inDegree[course]++;
    }

    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int i = queue.poll();
      cnt++;
      if (adjList[i] != null) {
        for (int x : adjList[i]) {
          inDegree[x]--;
          if (inDegree[x] == 0) {
            queue.add(x);
          }
        }
      }
    }

    return cnt == numCourses;
  }
}
