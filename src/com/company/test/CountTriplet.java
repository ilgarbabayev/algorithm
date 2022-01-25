package com.company.test;

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
        long count = 0L;
        Map<Long, Long> map = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

        long flag = 0;

        for (int i = 0; i < arr.size() - 2; i++) {
            long e = arr.get(i);
            if (flag == e){
                continue;
            } else {
                flag = e;
            }
            count += map.getOrDefault(e, 0L) * map.getOrDefault(e * r, 0L) * map.getOrDefault(e * r * r, 0L);
        }

        return count;
    }
}
