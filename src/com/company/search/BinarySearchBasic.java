package com.company.search;

import java.io.IOException;

public class BinarySearchBasic {
  public static void main(String[] args) throws IOException {
    int[] intArray = {-22, -15, 1, 7, 20, 35, 55};

    System.out.println(iterativeBinarySearch(intArray, -15));
    System.out.println(iterativeBinarySearch(intArray, 35));
    System.out.println(iterativeBinarySearch(intArray, 8888));
    System.out.println(iterativeBinarySearch(intArray, 1));

    System.out.println(recursiveBinarySearch(intArray, -15));
    System.out.println(recursiveBinarySearch(intArray, 35));
    System.out.println(recursiveBinarySearch(intArray, 8888));
    System.out.println(recursiveBinarySearch(intArray, 1));
  }

  private static int iterativeBinarySearch(int[] input, int value) {
    int start = 0;
    int end = input.length;

    while (start < end) {
      int midPoint = (start + end) / 2;
      if (input[midPoint] == value) {
        return midPoint;
      } else if (input[midPoint] < value) {
        start = midPoint + 1;
      } else {
        end = midPoint;
      }
    }

    return -1;
  }

  private static int recursiveBinarySearch(int[] input, int value) {
    return recursiveBinarySearch(input, 0, input.length, value);
  }

  private static int recursiveBinarySearch(int[] input, int start, int end, int value) {
    if (start >= end) return -1;

    int midPoint = (start + end) / 2;

    if (input[midPoint] == value) {
      return midPoint;
    } else if (input[midPoint] < value) {
      return recursiveBinarySearch(input, midPoint + 1, end, value);
    } else {
      return recursiveBinarySearch(input, start, midPoint, value);
    }
  }
}
