package com.company.FAANG.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class TimeToInformEmployees {
  public static void main(String[] args) {
//    int num = 8;
//    int headId = 4;
//    int[]  managersArray = new int[]{2, 2, 4, 6, -1, 4, 4, 5};
//    int[] informTimeArray = new int[]{0, 0, 4, 0, 7, 3, 6, 0};

    int num = 10;
    int headId = 3;
    int[]  managersArray = new int[]{8,9,8,-1,7,1,2,0,3,0};
    int[] informTimeArray = new int[]{224,943,160,909,0,0,0,643,867,722};

    System.out.println(numOfMinutes(num, headId, managersArray, informTimeArray));
  }

  public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

    List<Queue<Integer>> employees = new ArrayList<>(n);
    IntStream.range(0, n).forEach(x -> employees.add(new LinkedList<>()));

    for (int i = 0; i < manager.length; i++) {
      if (manager[i] != -1) {
        employees.get(manager[i]).add(i);
      }
    }

    if (employees.get(headID).isEmpty()) {
      return 0;
    }

    return getMax(headID, employees, informTime);
  }

  private static int getMax(int id, List<Queue<Integer>> employees, int[] informTimeArray) {
    Queue<Integer> innerQueue = employees.get(id);

    int innerTotalTime = 0;
    while (!innerQueue.isEmpty()) {
      int empId = innerQueue.poll();
      innerTotalTime = Math.max(innerTotalTime, getMax(empId, employees, informTimeArray));
    }

    return informTimeArray[id] + innerTotalTime;
  }
}
