package com.company.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {

        int[] arr = new int[]{4,7,-9,12,66,-65,89,4,66, 99, 125};
//        int[] arr = new int[]{1,2,3,4,5,6,6,7,8,9};

        boolean isSwap = true;
        int count = 0;
        int c = 0;

        while (isSwap) {
            isSwap = false;
            for (int i = 0; i < arr.length - 1 - count; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    isSwap = true;
                }
                c++;
            }
            count++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(c);
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
