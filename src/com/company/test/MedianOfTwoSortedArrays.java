package com.company.test;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
//    var nums1 = new int[] {1, 2, 3};
//    var nums2 = new int[] {4, 5, 6};

//    var nums1 = new int[] {1, 2};
//    var nums2 = new int[] {3, 4};

    var nums1 = new int[] {};
    var nums2 = new int[] {3};

    Solution solution = new Solution();

    System.out.println(solution.findMedianSortedArrays(nums1, nums2));
  }

}

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    var size = nums1.length + nums2.length;
    int mid;
    boolean odd;
    if (size % 2 != 0 ) {
      mid = (size / 2 );
      odd = true;
    } else {
      mid = (size / 2) - 1;
      odd = false;
    }

    int i = size - 1;
    int i01 = nums1.length - 1;
    int i02 = nums2.length - 1;

    int previous = -1;
    int current = -1;

    if (i01 >= 0) {
      previous = nums1[i01];
      current = nums1[i01];
    } else if (i02 >=0) {
      previous = nums2[i02];
      current = nums2[i02];
    }

    while (i >= mid) {
      if ((i01 >= 0 && i02 < 0) || nums1[i01] > nums2[i02]) {
        previous = current;
        current = nums1[i01];
        i01--;
      } else {
        previous = current;
        current = nums2[i02];
        i02--;
      }
      i--;
    }

    return odd ? current : (current + previous) / 2.0;
  }
}
