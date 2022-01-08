package com.company.test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumToys {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        System.out.println(getMax(list, 7));
    }

    private static Integer getMax(List<Integer> prices, int k) {
        int sum = 0;
        int count = 0;

        List<Integer> sorted = prices.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
        for (int x : sorted) {
            if((sum+x) <= k) {
                sum+=x;
                count++;
                System.out.println(x + " " + sum + " " + count);
            } else {
                return count;
            }
        }

        return count;
    }
}
