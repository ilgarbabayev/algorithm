package com.company.sort;

import java.util.Arrays;

public class Counting {
    private  static int count = 0;
    public static void main(String[] args) {
        int[] intArray = {2,5,7,4,3,9,10,8,6,5};


        countingSort(intArray, 1, 10);
        System.out.println("intArray = " + Arrays.toString(intArray));
        System.out.println(count);
    }

    private static void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
            count++;
        }

        int j = 0;

        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
                count++;
            }
        }

    }

}
