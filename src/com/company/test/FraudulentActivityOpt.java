package com.company.test;

import java.util.*;

public class FraudulentActivityOpt {
    public static void main(String[] args) {
        List<Integer> expenditure = new ArrayList<>(List.of(2, 3, 4, 1, 2, 3, 6, 8, 4, 5));
        int d = 5;
//        List<Integer> expenditure = List.of(10, 20, 30, 40, 50);
//        int d = 3;
//        List<Integer> expenditure = List.of(1,2,3,4,4);
//        int d = 4;

        int result = activityNotifications(expenditure, d);

        System.out.println(result);
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int result = 0;
        int mid;

        Window window = new Window();

        for (int i = 0; i < d; i++) {
            window.addElement(expenditure.get(i));
        }

        for (int i = d; i < expenditure.size(); i++){
            Integer next = expenditure.get(i);
            mid = window.getDoubleMedian();

            if (next >= mid) {
                result++;
            }

            window.remove(expenditure.get(i - d));
            window.addElement(next);
        }

        return result;
    }

    static class Window {
        PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> large = new PriorityQueue<>();

        private void addElement(Integer num) {
            if (large.isEmpty() || num >= large.peek()) {
                large.offer(num);
            } else {
                small.offer(num);
            }

            adjustSize();
        }

        private void remove(Integer num) {
            if (num >= large.peek()) {
                large.remove(num);
            } else {
                small.remove(num);
            }

            adjustSize();
        }

        private void adjustSize() {
            if (large.size() > small.size() + 1) {
                small.offer(large.poll());
            } else if (small.size() > large.size()) {
                large.offer(small.poll());
            }
        }

        private int getDoubleMedian() {
            if (large.size() > small.size()) {
                return large.peek() * 2;
            } else {
                return small.peek() + large.peek();
            }
        }

        public String toString() {
            return small + " - " + large;
        }
    }

}
