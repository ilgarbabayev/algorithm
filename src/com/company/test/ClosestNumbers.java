package com.company.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>(List.of(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470));
    System.out.println(closestNumbers(arr));
  }

  public static List<Integer> closestNumbers(List<Integer> arr) {
    Collections.sort(arr);

    int minDiff = Integer.MAX_VALUE;

    List<Integer> result = new ArrayList<>();

    for (int i = 1; i < arr.size(); i++) {
      int diff = arr.get(i) - arr.get(i - 1);
      if (diff <= minDiff) {
        if (diff < minDiff) {
          result = new ArrayList<>();
        }
        minDiff = diff;
        result.add(arr.get(i - 1));
        result.add(arr.get(i));
      }
    }

    return result;
  }
}
