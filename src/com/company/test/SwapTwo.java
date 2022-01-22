package com.company.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SwapTwo {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList());

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
            source.remove(index);
        }
        return randomList;
    }

    private static List<Integer> sortArr(Integer[] source) {
        int count = 0;
        for (int i = 0; i < source.length - 1; i++) {
            int element = source[i];
            if(element == i + 1) continue;
            int temp = element;
            int minIndex = i;
            int x;
            for (x = i + 1; x < source.length; x++) {
                if (source[x] < temp) {
                    temp = source[x];
                    minIndex = x;
                }
                if ( temp == i + 1) break;
            }
            if (temp < element) {
                source[i] = temp;
                source[minIndex] = element;
                count++;
            }
            System.out.println("source: " + Arrays.toString(source));
        }

        System.out.printf("count: %s\n", count);

        return List.of(source);
    }
}
