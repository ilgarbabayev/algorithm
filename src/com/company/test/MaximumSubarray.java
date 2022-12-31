package com.company.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.

Given an array, find the maximum possible sum among:

1) all nonempty subarrays.
2) all nonempty subsequences.
Print the two values as space-separated integers on one line.
 */

public class MaximumSubarray {
  public static void main(String[] args) {
//    var list = List.of(1,2,3,4);
    var list = List.of(2,-1,2,3,4,-5);
//    var list = List.of(-2,-3,-1,-4,-5);
//    var list = List.of(-1,-2,-3,-4,-5,-6);
//    var list = List.of(1,-1,-1,-1,-1,5);
//    var list = List.of(3,3,2,2,1,1,1,1,1,2,3);

    System.out.println(maxSubarray(list));
  }

  public static List<Integer> maxSubarray(List<Integer> arr) {
    Integer maxSA = maxSubArray(arr);
    Integer maxSS = maxSubSequence(arr);

    return List.of(maxSA, maxSS);
  }

  private static Integer maxSubArray(List<Integer> arr) {
    int extTempMax = Integer.MIN_VALUE;
    int intTempMax = Integer.MIN_VALUE;
    int sum = arr.get(0);
    for (int i = 1; i < arr.size(); i++) {
      var num = arr.get(i);
      if (num < 0) {
        if (sum < 0 && sum < num) {
          sum = num;
        } else if (sum > 0 && sum + num < 0 && extTempMax < sum) {
          extTempMax = sum;
          sum = 0;
        } else if (sum > 0 && sum + num > 0) {
          intTempMax = sum;
          sum += num;
        }

      } else {
        sum += num;
      }

    }

    return 0;
  }

  private static Integer maxSubSequence(List<Integer> arr) {
    Integer max = Integer.MIN_VALUE;
    int negative = Integer.MIN_VALUE;

    List<TreeMap<Integer, Integer>> list = new ArrayList<>();

    for (int i = 0; i <= Collections.max(arr); i++) {
      list.add(new TreeMap<>());
    }

    for (Integer num : arr) {
      if (num >= 0) {
        var m = list.get(num);
        var v = m.getOrDefault(num, 0);
        m.put(num, v + num);
        if (v + num > max) {
          max = v + num;
        }
        max = sumUp(list, num, max);
      } else {
        if (num > negative) {
          negative = num;
        }
      }

    }

    if (max < negative) {
      max = negative;
    }

    return max;
  }

  private static Integer sumUp(List<TreeMap<Integer, Integer>> list, Integer num, Integer max) {
    for (int i = 0; i < num; i++) {
      if (!list.get(i).isEmpty()) {
        var map = list.get(i);
        var value = map.getOrDefault(num, map.lowerEntry(num).getValue());
        map.put(num, value + num);
        if (value + num > max) {
          max = value + num;
        }
      }
    }

    return max;
  }
}
