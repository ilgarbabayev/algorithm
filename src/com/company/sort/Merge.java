package com.company.sort;

import java.util.Arrays;

public class Merge {

    private static  int count = 0;

    public static void main(String[] args) {
//        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
//        int[] intArray = {125, 99, 89, 66, 66, 12, 7, 4, 4, -9, -65 };
//        int[] intArray = {-9, 99,  66, 4, 66,  -65, 125, 12, 7, 89,  4};
        int[] intArray = {4,7,-9,12,66,-65,89,4,66, 99, 125};

        mergeSort(intArray, 0, intArray.length);

        System.out.println(Arrays.toString(intArray));
        System.out.println(count);
    }

    private static void mergeSort(int[] input, int start, int end) {

        System.out.println(start + " " + end);
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        System.out.println(start + " " + mid + " " + end);
        System.out.println("input = " + Arrays.toString(input));
        if (input[mid - 1] < input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            System.out.println("input[i] & input[j] = " + input[i] + " " + input[j]);
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
            count++;
        }

        System.out.println("temp = " + Arrays.toString(temp));

        System.out.println(i + " " + (start + tempIndex) + " " + (mid - i));

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.out.println("temp after copy 1 = " + Arrays.toString(input));

        System.arraycopy(temp, 0, input, start, tempIndex);
        System.out.println("temp after copy 2 = " + Arrays.toString(input));



    }
}
