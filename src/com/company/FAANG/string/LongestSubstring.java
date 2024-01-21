package com.company.FAANG.string;

import java.util.HashMap;
import java.util.Map;


/*

Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

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
