package com.company.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rotate {
    public static void main(String[] args) {
        List<Integer> arr = IntStream.range(0, 5).mapToObj(i -> new Random().nextInt(100)).collect(Collectors.toList());
        System.out.println(arr);
        System.out.println(rotate(arr, new Random().nextInt(6)));
    }

    private static List<Integer> rotate(List<Integer> source, int number) {

        for (int i = 0; i < number; i++) {
            int temp = source.get(0);
            source.remove(0);
            source.add(temp);
        }
        return source;
    }
}
