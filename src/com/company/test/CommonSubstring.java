package com.company.test;

import java.util.HashSet;
import java.util.Set;

public class CommonSubstring {
    public static void main(String[] args) {
//        String s1 = "hello";
        String s1 = "hi";
        String s2 = "world";

        System.out.println(contain(s1, s2));
    }

    private static String contain(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        String contains = "NO";
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }

        for (int x = 0; x < s2.length(); x++) {
            if (set.contains(s2.charAt(x))) {
                contains = "YES";
                break;
            }
        }

        return contains;
    }
}
