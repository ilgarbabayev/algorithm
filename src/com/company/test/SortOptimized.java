package com.company.test;

import java.util.Arrays;
import java.util.List;

public class SortOptimized {
    public static void main(String[] args) {

        System.out.println(optimize(Arrays.asList(9, 5, 7, 3, 1, 2, 6, 12)));

    }

    private static List<Integer> optimize(List<Integer> list) {
        boolean isSwap = true;
        int count = 0;
        while (isSwap) {
            isSwap = false;
            for(int i = 0; i< list.size()-1 - count; i++) {
                if (list.get(i) > list.get(i+1)) {
                    Integer temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    isSwap = true;
                }
            }
            count++;
        }

        System.out.println(count);

        return list;
    }
}
