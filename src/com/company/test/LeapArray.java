package com.company.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LeapArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        IntStream.range(1, new Random().nextInt(18) + 4).forEach(x -> {
            list.add(new Random().nextInt(2));
        });
        int leap = new Random().nextInt(8) + 1;
        System.out.println(list);
        System.out.println("leap: " + leap);

        boolean isCompleted = isSolvable(leap, list, 0);

        System.out.println(isCompleted);
    }

    private  static boolean isSolvable(int leap, List<Integer> list, int i) {
        if (i >= list.size()) return true;
        if (i < 0 || list.get(i) == 1) return false;

        list.set(i, 1);

        return isSolvable(leap, list, i + leap) ||
                isSolvable(leap, list, i + 1) ||
                        isSolvable(leap, list, i - 1);
    }
}
