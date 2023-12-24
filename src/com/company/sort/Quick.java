package com.company.sort;

import java.util.Arrays;

public class Quick {
    private  static int count = 0;
    public static void main(String[] args) {
        //        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
//        int[] intArray = {125, 99, 89, 66, 66, 12, 7, 4, 4, -9, -65 };
//        int[] intArray = {-9, 99,  66, 4, 66,  -65, 125, 12, 7, 89,  4};
//        int[] intArray = {4,7,-9,12,66,-65,89,4,66, 99, 125};
        int[] intArray = {4,7,8,-9,12,66,-65};


        quickSort(intArray, 0, intArray.length);
        System.out.println("intArray = " + Arrays.toString(intArray));
        System.out.println(count);
    }

    private static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int x = start;
        int y = end;

        while (x < y) {
            while (x < y && input[--y] >= pivot);

            if (x < y) {
                input[x] = input[y];
                count++;
            }

            while (x < y && input[++x] <= pivot);

            if (x < y) {
                input[y] = input[x];
                count++;
            }
        }

        input[y] = pivot;
        return y;
    }
}
