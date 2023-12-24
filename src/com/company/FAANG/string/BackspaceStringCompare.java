package com.company.FAANG.string;

public class BackspaceStringCompare {

/*  Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
  Note that after backspacing an empty text, the text will continue empty.*/

  public static void main(String[] args) throws RuntimeException {
    String s = "abc#d";
    String t = "abzz##d";
    boolean result = compareStrings(s, t);
    System.out.println(result);
  }

  public static boolean compareStrings(String S, String T) {

    var p1 = S.length() - 1;
    var p2 = T.length() - 1;

    while(p1 >= 0 || p2 >= 0) {
      if(S.charAt(p1) == '#' || T.charAt(p2) == '#') {
        if(S.charAt(p1) == '#') {
          var backCount = 2;

          while(backCount > 0) {
            p1--;
            backCount--;

            if(S.charAt(p1) == '#') {
              backCount += 2;
            }
          }
        }

        if(T.charAt(p2) == '#') {
          var backCount = 2;

          while(backCount > 0) {
            p2--;
            backCount--;

            if(T.charAt(p2) == '#') {
              backCount += 2;
            }
          }
        }
      } else {
        if(S.charAt(p1) != T.charAt(p2)) {
          return false;
        } else {
          p1--;
          p2--;
        }
      }
    }

    return true;
  }
}
