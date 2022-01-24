package com.company.test;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayManipulation {
    public static void main(String[] args) {
//        List<List<Integer>> queries = List.of(List.of(1,5,3), List.of(4,8,7), List.of(6,9,1));
        List<List<Integer>> queries = List.of(List.of(1,2,100), List.of(2,5,100), List.of(3,4,100));
        long result = arrayManipulation(10, queries);
        System.out.println(result);
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        Map<Integer, Long> map = new HashMap<>();
        queries.forEach(list -> {
            IntStream.rangeClosed(list.get(0), list.get(1)).forEach(num -> {
                Long value = map.getOrDefault(num, 0L);
                map.put(num, value + list.get(2));
            });
        });

        System.out.println(map);

        return Collections.max(map.values());
    }
}
