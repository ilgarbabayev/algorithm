package com.company.test;


import java.io.IOException;

public class PalindromeString {

    public static void main(String[] args) throws IOException {

        String[] pal = {"I did, did I?", "Racecar", "hello", "abccba", "Was it a car or a cat I saw?", "Don't nod"};

        for (int i = 0; i < pal.length; i++) {
            System.out.println(pal[i] + " : " + isPalindrome(pal[i]));
        }

    }

   static boolean isPalindrome(String str) {

        for (int i = 0, x = str.length() - 1; i <=x; i++, x--) {
            char ch1;
            char ch2;
            while (!Character.isAlphabetic(ch1 = str.charAt(i))) i++;
            while (!Character.isAlphabetic(ch2 = str.charAt(x))) x--;
            if (i >=x) return true;
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
        }

        return true;

   }
}




