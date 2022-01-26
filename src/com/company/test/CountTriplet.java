package com.company.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CountTriplet {
    public static void main(String[] args) {
//        List<Long> arr = List.of(1L,2L,2L,4L);
//        long r = 2;

//        List<Long> arr = List.of(1L, 3L, 9L, 9L, 27L, 81L);
//        long r = 3;

//        List<Long> arr = List.of(1L, 5L, 5L, 25L, 125L);
//        long r = 5;

        List<Long> arr = List.of(1L, 2L, 1L, 2L, 4L);
        long r = 2;

//        List<Long> arr = LongStream.generate(() -> 1L).limit(100).boxed().collect(Collectors.toList());
//        long r = 1;

        long result = countTriplets(arr, r);
        System.out.println(result);
    }

    private static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long, Long> rightMap = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Long, Long> leftMap = new HashMap<>();

        System.out.println(rightMap);

        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);
            long c1 = 0, c3 = 0;

            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);

            if (midTerm % r == 0) {
                c1 = leftMap.getOrDefault(midTerm / r, 0L);
            }

            c3 = rightMap.getOrDefault(midTerm * r, 0L);

            count += c1 * c3;

            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
        }

        return count;
    }
}
