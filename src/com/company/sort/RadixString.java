package com.company.sort;


import java.io.IOException;
import java.util.Arrays;

public class RadixString {

    public static void main(String[] args) throws IOException {
        String[] strArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        System.out.println(Arrays.toString(strArray));

        radixSort(strArray, 26, 5);

        System.out.println(Arrays.toString(strArray));
    }

    private static void radixSort(String[] input, int radix, int width) {
        for (int i = width - 1; i >=0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(String[] input, int i, int radix) {
        int len = input.length;
        int offset = 'a';
        int[] countArray = new int[radix];

        for (String in : input) {
            countArray[in.codePointAt(i) - offset]++;
        }

        for (int x = 1; x < radix; x++) {
            countArray[x] += countArray[x - 1];
        }

        String[] temp = new String[len];

        for (int y = len - 1; y >=0; y--) {
            temp[--countArray[input[y].codePointAt(i) - offset]] = input[y];
        }

        for (int z = 0; z < len; z++) {
            input[z] = temp[z];
        }
    }
}




