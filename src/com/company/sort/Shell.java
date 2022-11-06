package com.company.sort;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
//        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
//        int[] intArray = {125, 99, 89, 66, 66, 12, 7, 4, 4, -9, -65 };
//        int[] intArray = {-9, 99,  66, 4, 66,  -65, 125, 12, 7, 89,  4};

//        int[] intArray = {4,7,-9,12,66,-65,89,4,66, 99, 125};
        int[] intArray = {16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(intArray));
        System.out.println("=========================");

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            System.out.println(gap);

            for (int i = gap; i < intArray.length; i++) {

                int newElement = intArray[i];
                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }
            System.out.println(Arrays.toString(intArray));
        }
        System.out.println("=========================");
        System.out.println(Arrays.toString(intArray));
    }
}
