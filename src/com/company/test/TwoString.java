package com.company.test;

public class TwoString {
    public static void main(String[] args) {

    }

    private static String twoString(String s1, String s2) {
        if (s1.length() < s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (s2.indexOf(c) > 0) return "Yes";
            }
        } else {
            for (int i = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                if (s1.indexOf(c) > 0) return "Yes";
            }
        }
        return "No";
    }
}
