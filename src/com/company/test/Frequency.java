package com.company.test;

import java.util.*;

public class Frequency {
    public static void main(String[] args) {
//        List<List<Integer>> queries = List.of(List.of(1,1), List.of(2,2), List.of(3,2), List.of(1,1), List.of(1,1), List.of(2,1), List.of(3,2));
        List<List<Integer>> queries = List.of(List.of(3,4), List.of(2,1003), List.of(1,16), List.of(3,1));

        List<Integer> answer = freqQuery(queries);

        System.out.println(answer);
    }

    private static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> freqValue = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        queries.forEach(query -> {
            int type = query.get(0);
            int num = query.get(1);

            if (type == 1) {
                Integer freqMapAdd = freqMap.getOrDefault(num, 0);
                Integer valueSubTract = freqValue.getOrDefault(freqMapAdd, 0);

                if (valueSubTract > 0) {
                    freqValue.put(freqMapAdd, --valueSubTract);
                }

                freqMap.put(num, ++freqMapAdd );


                Integer freqValueAdd = freqValue.getOrDefault(freqMapAdd, 0);
                freqValue.put(freqMapAdd, ++freqValueAdd);

            } else if (type == 2) {
                Integer freqMapSubtract = freqMap.getOrDefault(num, 0);

                if (freqMapSubtract > 0) {
                    Integer freqValueSubtract = freqValue.getOrDefault(freqMapSubtract, 0);

                    if (freqValueSubtract > 0) {
                        freqValue.put(freqMapSubtract, --freqValueSubtract);
                    }

                    freqMap.put(num, --freqMapSubtract);

                    Integer freqValueAdd = freqValue.getOrDefault(freqMapSubtract, 0);
                    freqValue.put(freqMapSubtract, ++freqValueAdd);
                }

            } else {
                if (freqValue.getOrDefault(num, 0) > 0 ) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
            }
        });

        return answer;
    }

}
