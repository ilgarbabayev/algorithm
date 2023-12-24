package com.company.FAANG.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));
//    System.out.println(isValid("("));
  }

  public static boolean isValid(String s) {
    ArrayDeque<Character> queue = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '{' || ch == '[') {
        queue.add(ch);
      } else {
        if (queue.isEmpty()) {
          return false;
        } else {
          if (!isValid(queue.peekLast(), ch)) {
            return false;
          } else {
            queue.pollLast();
          }
        }
      }
    }

    return queue.isEmpty();
  }

  private static boolean isValid(char a, char b) {
    return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
  }
}
