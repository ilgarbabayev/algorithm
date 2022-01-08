package com.company.sort;

import java.util.Arrays;

public class Quick {
    private  static int count = 0;
    public static void main(String[] args) {
        //        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
//        int[] intArray = {125, 99, 89, 66, 66, 12, 7, 4, 4, -9, -65 };
//        int[] intArray = {-9, 99,  66, 4, 66,  -65, 125, 12, 7, 89,  4};
        int[] intArray = {4,7,-9,12,66,-65,89,4,66, 99, 125};
//        int[] intArray = {4,7,8,-9,12,66,-65};


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
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && input[--j] >= pivot);

            if (i < j) {
                input[i] = input[j];
                count++;
            }

            while (i < j && input[++i] <= pivot);

            if (i < j) {
                input[j] = input[i];
                count++;
            }
        }

        input[j] = pivot;
        return j;
    }
}
