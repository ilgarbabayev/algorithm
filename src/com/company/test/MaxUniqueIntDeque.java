package com.company.test;

import java.util.*;
import java.util.stream.IntStream;

public class MaxUniqueIntDeque {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, new Random().nextInt(10) + 5).forEach(x -> list.add(new Random().nextInt(11)));

        Integer randomInt = new Random().nextInt(list.size() / 2) + 3;

        System.out.println(list);
        System.out.println(randomInt);
        System.out.println(findMaxInt(list, randomInt));
    }

    private static Integer findMaxInt(List<Integer> list, Integer size) {
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for (Integer num : list) {
            deque.add(num);
            addToMap(map, deque.getLast());
            if (deque.size() > size) {
                removeFromMap(map, deque.removeFirst());
            }
            if (max < map.size()) max = map.size();

            System.out.println(deque);
            System.out.println(map);
        }

        return max;
    }

    private static void addToMap(Map<Integer, Integer> map, Integer number) {
        Integer num = map.getOrDefault(number, 0);
        map.put(number, num + 1);
    }

    private static void removeFromMap(Map<Integer, Integer> map, Integer number) {
        Integer num = map.get(number);
        if (num <=1) {
            map.remove(number);
        } else {
            map.put(number, num - 1);
        }
    }
}
