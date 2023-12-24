package com.company.FAANG.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrapRainWater {

  // verilmish reqemlerin hundurluyu ifader edir.
  //bu hundurlukler arasinda ne qeder yagish suyunun yilia bileceyini hesabla

  public static void main(String[] args) throws RuntimeException {
//    int[] nums = {0,1,0,2,1,0,3,1,0,1,2};
//    int[] nums = {5,0,3,0,0,0,2,3,4,2,1};
    int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
    int result = calcTotalWater(nums);
    System.out.println(result);
  }

  public static int calcTotalWater(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxLeft = 0;
    int maxRight = 0;
    int total = 0;

    while (left < right) {
      if (height[left] <= height[right]) {
        if (height[left] >= maxLeft) {
          maxLeft = height[left];
        } else {
          total += maxLeft - height[left];
        }
        left++;
      } else {
        if (height[right] >= maxRight) {
          maxRight = height[right];
        } else {
          total += maxRight - height[right];
        }

        right--;
      }
    }

    return total;
  }
}
