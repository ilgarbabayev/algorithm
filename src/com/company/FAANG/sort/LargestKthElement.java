package com.company.FAANG.sort;

import java.util.Random;

public class LargestKthElement {
  public static void main(String[] args) {
    int[] arr = new int[]{1,5,3,6,9,4,2,11,8};
//    int[] arr = new int[]{1,2,3,4,5,6,7};
    Solution solution = new Solution();

    System.out.println(solution.findKthLargest(arr, 4));
  }
}

class Solution {
  public int findKthLargest(int[] nums, int k) {
    int left = 0;
    int right = nums.length - 1;
    Random rand = new Random();
    while (true) {
      int pivot_index = left + rand.nextInt(right - left + 1);
      int new_pivot_index = partition(nums, left, right, pivot_index);
      if (new_pivot_index == nums.length - k) {
        return nums[new_pivot_index];
      } else if (new_pivot_index > nums.length - k) {
        right = new_pivot_index - 1;
      } else {
        left = new_pivot_index + 1;
      }
    }
  }

  private int partition(int[] nums, int left, int right, int pivot_index) {
    int pivot = nums[pivot_index];
    swap(nums, pivot_index, right);
    int stored_index = left;
    for (int i = left; i < right; i++) {
      if (nums[i] < pivot) {
        swap(nums, i, stored_index);
        stored_index++;
      }
    }
    swap(nums, right, stored_index);
    return stored_index;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
