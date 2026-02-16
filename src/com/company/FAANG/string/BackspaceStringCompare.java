package com.company.FAANG.string;

public class BackspaceStringCompare {

/*  Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
  Note that after backspacing an empty text, the text will continue empty.*/

    public static void main(String[] args) throws RuntimeException {
        System.out.println(new BackspaceStringCompare().backspaceCompare("abc#d", "abzz##d"));
        System.out.println(new BackspaceStringCompare().backspaceCompare("ab##", "c#d#"));
        System.out.println(new BackspaceStringCompare().backspaceCompare("a#c", "b"));
    }

    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;

        while (p1 >= 0 && p2 >= 0) {
            p1 = getNextValidChar(s, p1);
            p2 = getNextValidChar(t, p2);

            if (p1 < 0 && p2 < 0) {
                return true;
            }

            if (p1 < 0 || p1 < 0) {
                return false;
            }

            if (s.charAt(p1) != t.charAt(p2)) {
                return false;
            }

            p1--;
            p2--;
        }

        return true;
    }

    private int getNextValidChar(String str, int end) {
        int backspace = 0;

        while (end >= 0) {
            if (str.charAt(end) == '#') {
                backspace++;
            } else if (backspace > 0) {
                backspace--;
            } else {
                break;
            }

            end--;
        }

        return end;
    }
}
