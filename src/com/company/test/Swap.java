package com.company.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Swap {
    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(1, i -> ++i).limit(8).boxed().collect(Collectors.toList());
        System.out.println(list);

        List<Integer> listRandom = getRandom(list);
        System.out.println(listRandom);

        Integer[] listInt = listRandom.toArray(new Integer[0]);
        System.out.println(sortArr(listInt));
    }

    public static List<Integer> getRandom(List<Integer> source) {
        List<Integer> randomList = new ArrayList<>();
        while (source.size()>0) {
            int index = new Random().nextInt(source.size());
            int indexValue = source.get(index);
            randomList.add(indexValue);
            source.set(index, source.get(source.size()-1));
            source.remove(source.size()-1);
        }
        return randomList;
    }

    private static List<Integer> sortArr(Integer[] source) {

        int size = source.length;
        int count = 0;

        for (int x = 0; x < size-1; x++) {
            int temp = source[x];
            int min = source[x+1];
            int minIndex = x+1;

            for (int y = x; y < size-1; y++) {
                if (min > source[y+1] ) {
                    min = source[y+1];
                    minIndex = y+1;
                }
            }
            System.out.println("temp: " + temp);
            System.out.println(min + " - " + minIndex);
            if (temp > min) {
                int temp2 = source[x];
                source[x] = source[minIndex];
                source[minIndex] = temp2;
                count++;
            }

            System.out.println(List.of(source));
        }

        System.out.println("count " + count);

        return List.of(source);
    }
}
