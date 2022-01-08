package com.company.sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
//        int[] arr = new int[]{4,7,-9,12,66,-65,89,4,66, 99, 125};
//        int[] arr = new int[]{125, 99, 89, 66, 66, 12, 7, 4, 4, -9, -65 };
        int[] arr = new int[]{-9, 99,  66, 4, 66,  -65, 125,12, 7, 89,  4};

        int count = 0;

        for (int lastIndex = 1; lastIndex < arr.length; lastIndex++) {
            int newElement = arr[lastIndex];
            int i;

            for (i = lastIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
                count++;
            }

            arr[i] = newElement;

        }

        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }
}
