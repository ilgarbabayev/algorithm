package com.company.test;

import java.util.*;
import java.util.stream.Collectors;

public class Magazine {
    public static void main(String[] args) {
        List<String> magazine = Arrays.stream("give me one grand today night".split(" ")).collect(Collectors.toList());
        List<String> note = List.of("two times two is four".split(" "));

        checkMagazine(magazine, note);
    }

    private static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> check = new HashMap<>();

        magazine.forEach(n -> {
            Integer temp = check.get(n);
            if (temp==null) {
                check.put(n, 1);
            } else {
                check.put(n , ++temp);
            }
        });

        for (String n : note) {
            Integer value = check.get(n);
            if (value == null) {
                System.out.println("No");
                return;
            } else {
                Integer decrement = --value;
                check.put(n,decrement);
                if (decrement < 0) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");

        System.out.println(check);

    }
}
