package com.company.FAANG.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumBracketsToRemove {
  public static void main(String[] args) {
    System.out.println(minRemoveToMakeValid("a)bc(d)"));
    System.out.println(minRemoveToMakeValid("(ab(c)d)"));
    System.out.println(minRemoveToMakeValid("))(("));
  }

  public static String minRemoveToMakeValid(String s) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        queue.add(i);
      } else if (ch == ')') {
        if (!queue.isEmpty() && s.charAt(queue.peekLast()) == '(') {
          queue.pollLast();
        } else {
          queue.add(i);
        }
      }
    }

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (!queue.isEmpty() && queue.peekFirst() == i) {
        queue.pollFirst();
      } else {
        builder.append(s.charAt(i));
      }
    }

    return builder.toString();
  }

}
