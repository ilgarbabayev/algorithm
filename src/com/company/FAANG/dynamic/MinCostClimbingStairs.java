package com.company.FAANG.dynamic;

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
 */

public class MinCostClimbingStairs {
  public static void main(String[] args) {
    int[] cost1 = {10,15,20};
    int[] cost2 = {1,100,1,1,1,100,1,1,100,1};

    System.out.println(minCostClimbingStairs(cost1));
    System.out.println(minCostClimbingStairs(cost2));
  }

  public static int minCostClimbingStairs(int[] cost) {
    int n = cost.length ;
    for(int i=2 ; i<n ; i++){
      cost[i] = Math.min(cost[i-1] , cost[i-2]) + cost[i];
    }
    return Math.min(cost[n-1] , cost[n-2]);
  }
}
