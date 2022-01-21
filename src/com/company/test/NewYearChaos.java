package com.company.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewYearChaos {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(1, 6).boxed().collect(Collectors.toList());
        List<Integer> listRandom = getRandom(list);
//        List<Integer> listRandom = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);
        System.out.println(listRandom);

        int max = 0;
        boolean isExceeded = false;

        outerloop:
        for (int i = listRandom.size() - 2; i >= 0; i--) {
            int newElement = listRandom.get(i);

            int count = 0;
            int x;
            for (x = i; x < listRandom.size() - 1 &&  newElement > listRandom.get(x + 1); x++) {
                listRandom.set(x, listRandom.get(x+1));
                count++;
                if (count > 2) {
                    isExceeded = true;
                    break outerloop;
                }
            }
            listRandom.set(x, newElement);
            System.out.println(listRandom);
            max += count;
        }

        String print = isExceeded ? "Too chaotic" : String.valueOf(max);

        System.out.println(max);
        System.out.println(print);
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
}
