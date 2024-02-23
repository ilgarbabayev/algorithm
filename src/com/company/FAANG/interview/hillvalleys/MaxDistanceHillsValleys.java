package com.company.FAANG.interview.hillvalleys;


public class MaxDistanceHillsValleys {

  public static void main(String[] args) {
    int[] arr1 = new int[] {1,5,7,4};
    int[] arr2 = new int[] {2,6,6,3,7};
    int[] arr3 = new int[] {2,2};
    int[] arr4 = new int[] {1,400,250,550,600,700,800,2,5,7,9,11,22,33,44,55,66,8000};
    int result1 = solution(arr1);
    int result2 = solution(arr2);
    int result3 = solution(arr3);
    int result4 = solution(arr4);

    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
    System.out.println(result4);
  }

  private static int solution(int[] blocks) {
    int left = 0;
    int right = 0;
    int max = 1;

    while (right < blocks.length - 1) {
      while (right < blocks.length - 1 && blocks[right] <= blocks[right + 1]) {
        right++;
      }

      while (left > 0 && blocks[left - 1] >= blocks[left]) {
        left--;
      }
      max = Math.max(max, (right - left) + 1);

      left = right;

      while (right < blocks.length - 1 && blocks[right + 1] < blocks[right]) {
        right++;
      }
    }

    return max;
  }

}
