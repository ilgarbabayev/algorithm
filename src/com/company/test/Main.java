package com.company.test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(1, i -> ++i).limit(8).boxed().collect(Collectors.toList());
        list = Swap.getRandom(list);
        System.out.println(list);

        int minIndex = IntStream.range(0,list.size()).boxed()
                .min(Comparator.comparingInt(list::get))
                .get();
        System.out.println(minIndex);
    }
}
