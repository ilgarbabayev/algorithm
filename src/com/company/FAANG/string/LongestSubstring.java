package com.company.FAANG.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
  public static void main(String[] args) {
//    var s1 = "abcabcbb";
//    var s1 = "bbbbb";
//    var s1 = "pwwkew";
//    var s1 = " ";
//    var s1 = "dvdf";
    var s1 = "aabaab!bb";

    var r1 = lengthOfLongestSubstring(s1);


    System.out.println(r1);

  }

  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    int l = 0;
    int r = 0;

    while (r < s.length()) {
      char c = s.charAt(r);
      Integer index = map.get(c);
      if (index != null && index >= l) {
        l = index + 1;
      }
      map.put(c, r);
      max = Math.max(max, r - l + 1);
      r++;
    }

    return max;
  }
}
