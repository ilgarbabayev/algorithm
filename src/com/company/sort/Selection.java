package com.company.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {

        int[] arr = new int[]{4,7,-9,12,66,-65,89,4,66, 99, 125};
        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22};

        for (int unsortedIndex = arr.length-1; unsortedIndex > 0; unsortedIndex--) {
            int largest = 0;

            for (int i = 1; i <= unsortedIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }

            swap(arr, largest, unsortedIndex);
        }

        System.out.println(Arrays.toString(intArray));
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
