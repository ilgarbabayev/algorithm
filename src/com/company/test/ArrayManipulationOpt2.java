package com.company.test;

import java.util.Arrays;
import java.util.List;

public class ArrayManipulationOpt2 {
    public static void main(String[] args) {
        List<List<Integer>> queries = MockData.getMockData(5);

        long result = arrayManipulation(40, queries);
        System.out.println(result);
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        System.out.println(queries);

        return findHighest(n, queries);
    }

    public static long findHighest(int n, List<List<Integer>> queries) {
        long[] array = new long[n + 1];

        for (List<Integer> query : queries) {
            int a = query.get(0) - 1;
            int b = query.get(1) - 1;
            int v = query.get(2);

            array[a] += v;
            array[b + 1] -= v;
        }

        System.out.println(Arrays.toString(array));

        long max = Long.MIN_VALUE;

        for (int x = 1; x < array.length; x++) {
            array[x] += array[x-1];
            max = Math.max(max, array[x]);
        }

        return max;
    }
}