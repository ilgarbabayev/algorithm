package com.company.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SwapCountMerge {

    private static long count = 0;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2,1,3,1,2));

        System.out.println("result: " + countInversions(list));
    }

    public static long countInversions(List<Integer> arr) {

        int[] array = arr.stream().mapToInt(i -> i).toArray();

        mergeSort(array, 0, array.length);

        System.out.println("array: " + Arrays.toString(array));

        return count;
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (end + start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {

        if (arr[mid - 1] < arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        }

        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempIndex);

    }
}
