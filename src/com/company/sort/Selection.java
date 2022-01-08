package com.company.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {

        int[] arr = new int[]{4,7,-9,12,66,-65,89,4,66, 99, 125};
        int[] arr03 = new int[]{4,7,-9,12,66,-65,89,4,66, 99, 125};
//        int[] arr = new int[]{1,2,3,4,5,6,6,7,8,9};
//        int[] arr03 = new int[]{1,2,3,4,5,6,6,7,8,9};
        int count = 0;

        for (int unsortedIndex = arr.length-1; unsortedIndex > 0; unsortedIndex--) {
            int largest = 0;

            for (int i = 1; i <= unsortedIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
                count++;
            }

            swap(arr, largest, unsortedIndex);
        }

        boolean isSwap = true;
        int count03 = 0;
        int c03 = 0;
        while (isSwap) {
            isSwap = false;
            int largest = 0;
            System.out.println("arr03.length - 1 - count03 = " + (arr03.length - 1 - count03));
            for (int i = 1; i <= arr03.length - 1 - count03; i++) {
                if (arr03[i] > arr03[largest]) {
                    System.out.println(arr03[i] + " - " + arr03[largest]);
                    largest = i;
                }
                c03++;
            }
            if (largest != 0 || largest != arr03.length - 1 - count03) {
                isSwap = true;
                swap03(arr03, largest, arr03.length - 1 - count03);
            }

            count03++;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(count);
        System.out.println(Arrays.toString(arr03));
        System.out.println(c03);

    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void swap03(int[] arr, int x, int y) {
        System.out.println(Arrays.toString(arr) + " " + x + " " + y);
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
