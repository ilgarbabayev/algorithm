package com.company.FAANG.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUp {

  // verilmish reqemlerin icinde ele 2 sini tapmaq lazimdir ki, onlarin cemi target reqemi versin.
  //tapilmish reqemlerin indeksini qaytar

  public static void main(String[] args) throws RuntimeException {
    int[] nums = {1, 3, 7, 9, 2};
    int[] result = twoSumOptimized(nums, 11);
    System.out.println(Arrays.toString(result));
  }

  public static int[] twoSumOptimized(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int[] result = new int[2];

    if (nums.length < 2) {
      return null;
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (!map.containsKey(nums[i])) {
          map.put(target - nums[i], i);
        } else {
          result[0] = map.get(nums[i]);
          result[1] = i;
          return result;
        }
      }
    }

    return null;
  }
}
