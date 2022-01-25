package com.company.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagram {
    public static void main(String[] args) {
//        String s = "abba";
        String s = "kkkk";

        System.out.println("Number of matches: " + findAnagram(s));
    }

    private static int findAnagram(String s) {
        Map<String, Integer> map = new HashMap<>();

        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] charArray = s.substring(i, j).toCharArray();
                Arrays.sort(charArray);
                String sorted = String.valueOf(charArray);

                Integer value = map.getOrDefault(sorted, 0);
                totalCount += value;
                map.put(sorted, ++value);
            }
        }

        System.out.println(map);

        return totalCount;
    }
}
