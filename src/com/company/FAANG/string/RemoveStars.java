package com.company.FAANG.string;

public class RemoveStars {
    public static void main(String[] args) {
        String str1 = "leet**cod*e";
        String str2 = "erase*****";
        System.out.println(removeStars(str1));
//        System.out.println(removeStars(str2));
    }

    public static String removeStars(String str) {
        int pointer = str.length() - 1;
        StringBuilder builder = new StringBuilder();

        while (pointer >=0) {
            if (str.charAt(pointer) == '*') {
                int back = 2;
                while (back > 0 && pointer >= 0) {
                    pointer--;
                    back--;
                    if (pointer >= 0 && str.charAt(pointer) == '*') {
                        back+=2;
                    }
                }
            } else {
                builder.append(str.charAt(pointer));
                pointer--;
            }
        }

        return builder.reverse().toString();
    }
}
