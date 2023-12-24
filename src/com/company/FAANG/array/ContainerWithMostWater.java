package com.company.FAANG.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ContainerWithMostWater {

  // koordinat oxu uerinde reqemler verilir, her reqem bir vertikal xette beraberdir.
  // bu xettlerin icerisinde en boyuk sahe yaradacaq ve icini su ile doldurula bilecek 2-sini tap
  // nezere al ki, su ile doldurulmaq o demekdir ki,
  // alinan konteynerin en hundur zirvesi iki xettden en kiciyinden hundur ola bilmez

  public static void main(String[] args) throws RuntimeException {
    int[] nums = {3, 7, 1, 2, 9, 5};
//    int[] nums = {1,0,0,0,0,0,0,2,2};
    int result = maxArea(nums);
    System.out.println(result);
  }

  public static int maxArea(int[] height) {

    int p1 = 0;
    int p2 = height.length - 1;
    int area = 0;

    while (p1 < p2) {
      int hi = Math.min(height[p1], height[p2]);
      int distance = p2 - p1;
      area = Math.max(area, hi * distance);

      if (height[p1] <= height[p2]) {
        p1++;
      } else {
        p2--;
      }
    }

    return area;
  }
}
