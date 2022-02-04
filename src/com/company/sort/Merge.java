package com.company.sort;

import java.util.Arrays;

public class Merge {

    private static  int count = 0;

    public static void main(String[] args) {
//        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
//        int[] intArray = {125, 99, 89, 66, 66, 12, 7, 4, 4, -9, -65 };
//        int[] intArray = {-9, 99,  66, 4, 66,  -65, 125, 12, 7, 89,  4};
        int[] intArray = {7,4,-9,12,66,-65,89,4,66, 125, 99};

        System.out.println("intArray = " + Arrays.toString(intArray));

        mergeSort(intArray, 0, intArray.length);
    }

    private static void mergeSort(int[] input, int start, int end) {

        System.out.println("========= start = " + start + ", end = " + end);

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        System.out.println("start = " + start + ", mid = " + mid + ", end = " + end);

        if (input[mid - 1] < input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
