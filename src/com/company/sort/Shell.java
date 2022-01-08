package com.company.sort;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
//        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
//        int[] intArray = {125, 99, 89, 66, 66, 12, 7, 4, 4, -9, -65 };
//        int[] intArray = {-9, 99,  66, 4, 66,  -65, 125, 12, 7, 89,  4};
        int[] intArray = {4,7,-9,12,66,-65,89,4,66, 99, 125};

        int count = 0;

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            System.out.println(Arrays.toString(intArray));
            System.out.println("gap = " + gap);
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                System.out.println("newElement = " + newElement);
                int j = i;
                System.out.println("= " + intArray[j - gap]);
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    System.out.println("j = " + j);
                    j -= gap;
                    System.out.println("j = " + j);
                    count++;
                }
                count++;
                intArray[j] = newElement;
            }
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println(count);
    }
}
