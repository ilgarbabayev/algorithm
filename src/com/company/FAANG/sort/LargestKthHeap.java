package com.company.FAANG.sort;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutionException;

public class LargestKthHeap {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    int[] arr = new int[]{1,5,3,6,9,3,2};

    System.out.println(findKthLargest(arr, 2));
  }

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }

    return minHeap.peek();
  }
}