package com.company.test;

import java.util.*;
import java.util.stream.Collectors;

public class FraudulentActivity {
    public static void main(String[] args) {
//        List<Integer> expenditure = new ArrayList<>(List.of(2, 3, 4, 2, 3, 6, 8, 4, 5));
//        int d = 5;
//        List<Integer> expenditure = List.of(10, 20, 30, 40, 50);
//        int d = 3;
        List<Integer> expenditure = List.of(1,2,3,4,4);
        int d = 4;

        int result = activityNotifications(expenditure, d);

        System.out.println(result);
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int result = 0;
        int mid = d/2;
        int[] arr = new int[201];

        for (int i = 0; i < d; i++) {
            int value = expenditure.get(i);
            arr[value]++;
        }
        int[] sorted = sort(arr, d);

        for (int i = 0; i < expenditure.size() - d - 1; i++) {
            Integer toRemove = expenditure.get(i);
            Integer toAdd = expenditure.get(i + d);

            int median = findMedian(sorted, mid);

            if (toAdd >= median) {
                result++;
            }

            sorted = updateArray(arr, toRemove, toAdd, d);

            System.out.println(expenditure);
        }

        return result;
    }

    private static int findMedian(int[] arr, int mid) {
        int m;
        if (arr.length % 2 == 1) {
            m = arr[mid] * 2;
            return m;
        } else {
            m = (arr[mid] + arr[mid - 1]);
            return m;
        }
    }

    private static int[] updateArray(int[] arr, int head, int tail, int d) {
        arr[head]--;
        arr[tail]++;
        return sort(arr, d);
    }

    private static int[] sort(int[] arr, int d) {

        System.out.println(Arrays.toString(arr));

        int[] sorted = new int[d];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int x = 0; x < arr[i]; x++) {
                sorted[index++] = i;
            }
        }

        System.out.println(Arrays.toString(sorted));

        return sorted;
    }
}
