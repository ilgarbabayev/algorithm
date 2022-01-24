package com.company.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class ArrayManipulationOpt {
    public static void main(String[] args) {
//        List<List<Integer>> queries = List.of(List.of(1,5,3), List.of(4,8,7), List.of(6,9,1));
        List<List<Integer>> queries = MockData.getMockData(5);
        long result = arrayManipulation(10, queries);
        System.out.println(result);
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        queries.sort(Comparator.comparingInt(list -> list.get(0)));

        System.out.println(queries);

        return findHighest(queries);
    }

    public static long findHighest(List<List<Integer>> queries) {
        AtomicLong highestValue = new AtomicLong(0);

        Interval first = new Interval(queries.get(0).get(0), queries.get(0).get(1), queries.get(0).get(2));
        highestValue.addAndGet(queries.get(0).get(2));

        for (int i = 1; i < queries.size(); i++) {
            Interval toAdd = new Interval(queries.get(i).get(0), queries.get(i).get(1), queries.get(i).get(2));
            Interval next = first;

            while (next != null && !toAdd.isBeforeThan(next) && !toAdd.equals(next)) {
                if (toAdd.getEnd() < next.getEnd()) {
                    Interval newInterval = new Interval(next);
                    newInterval.setStart(toAdd.getEnd() + 1);

                    next.setStart(toAdd.getStart());
                    next.setEnd(toAdd.getEnd());
                    next.setValue(next.getValue() + toAdd.getValue());
                    next.setNext(newInterval);

                } else if (toAdd.getEnd() == next.getEnd()) {
                    next.setStart(toAdd.getStart());
                    next.setEnd(toAdd.getEnd());
                    next.setValue(next.getValue() + toAdd.getValue());

                }else {
                    if (toAdd.getStart() <= next.getEnd()) {
                        next.setStart(toAdd.getStart());
                        next.setValue(next.getValue() + toAdd.getValue());
                        toAdd.setStart(next.getEnd() + 1);

                        if ( !next.hasNext() ) {
                            next.setNext(toAdd);
                        }
                    } else if (next.hasNext()){
                        first = next = next.getNext();
                        continue;
                    } else if  (!next.hasNext() && toAdd.getStart() > next.getEnd()) {
                        first = next = toAdd;
                    }

                }

                if (next.getValue() > highestValue.longValue()) {
                    highestValue.set(next.getValue());
                }
                next = next.getNext();
            }
        }

        System.out.println(first);

        return highestValue.longValue();
    }
}

class Interval {
    private int start;
    private int end;
    private long value;
    private Interval next;

    public Interval(int start, int end, long value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public Interval(Interval interval) {
        this.start = interval.getStart();
        this.end = interval.getEnd();
        this.value = interval.getValue();
        this.next = interval.getNext();
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public long getValue() {
        return value;
    }

    public Interval getNext() {
        return next;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setNext(Interval next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public boolean isBeforeThan(Interval interval) {
        return this.start < interval.getStart() && this.end < interval.getStart();
    }

    @Override
    public String toString() {
        return "start=" + start +
                ", end=" + end +
                ", value=" + value +
                " => " + next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;

        Interval interval = (Interval) o;

        if (getStart() != interval.getStart()) return false;
        if (getEnd() != interval.getEnd()) return false;
        return getValue() == interval.getValue();
    }

    @Override
    public int hashCode() {
        int result = getStart();
        result = 31 * result + getEnd();
        result = 31 * result + (int) (getValue() ^ (getValue() >>> 32));
        return result;
    }
}

class MockData {
    public static List<List<Integer>> getMockData(int index) {
        List<List<List<Integer>>> mockData = new ArrayList<>();
        List<List<Integer>> queries1 = new ArrayList<>();
        queries1.add(List.of(4, 8, 7));
        queries1.add(List.of(1, 5, 3));
        queries1.add(List.of(6, 9, 1));

        List<List<Integer>> queries2 = new ArrayList<>();
        queries2.add(List.of(4, 8, 7));
        queries2.add(List.of(1, 6, 3));
        queries2.add(List.of(5, 9, 1));

        List<List<Integer>> queries3 = new ArrayList<>();
        queries3.add(List.of(3, 6, 7));
        queries3.add(List.of(1, 7, 3));
        queries3.add(List.of(4, 5, 1));

        List<List<Integer>> queries4 = new ArrayList<>();
        queries4.add(List.of(1, 2, 100));
        queries4.add(List.of(2, 5, 100));
        queries4.add(List.of(3, 4, 100));

        List<List<Integer>> queries5 = new ArrayList<>();
        queries5.add(List.of(2, 3, 603));
        queries5.add(List.of(1, 1, 286));
        queries5.add(List.of(4, 4, 882));

        List<List<Integer>> queries6 = new ArrayList<>(Arrays.asList(
                List.of(29, 40, 787), List.of(9,26,219), List.of(21,31,214), List.of(8,22,719), List.of(15,23,102),
                List.of(11,24,83), List.of(14,22,321), List.of(5,22,300), List.of(11,30,832), List.of(5,25,29),
                List.of(16,24,577), List.of(3,10,905), List.of(15,22,335), List.of(29,35,254), List.of(9,20,20),
                List.of(33,34,351), List.of(30,38,564), List.of(11,31,969), List.of(3,32,11), List.of(29,35,267),
                List.of(4,24,531), List.of(1,38,892), List.of(12,18,825), List.of(25,32,99), List.of(3,39,107),
                List.of(12,37,131), List.of(3,26,640), List.of(8,39,483), List.of(8,11,194), List.of(12,37,502)
        ));

        mockData.add(queries1);
        mockData.add(queries2);
        mockData.add(queries3);
        mockData.add(queries4);
        mockData.add(queries5);
        mockData.add(queries6);

        return mockData.get(index);
    }
}