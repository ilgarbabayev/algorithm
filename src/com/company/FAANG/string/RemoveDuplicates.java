package com.company.FAANG.string;

import java.util.Deque;
import java.util.LinkedList;

/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"


Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lowercase English letters.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        String str1 = "deeedbbcccbdaa";
        int k1 = 3;

        String str2 = "pbbcggttciiippooaais";
        int k2 = 2;

        System.out.println(removeDuplicates(str1, k1));
        System.out.println(removeDuplicates(str2, k2));
    }

    public static String removeDuplicates(String s, int k) {
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (deque.peek() == null) {
                deque.addLast(new int[]{ch, 1});
            } else {
                int[] last = deque.getLast();
                if (ch == last[0]) {
                    if (++last[1] >= k) {
                        deque.pollLast();
                    }
                } else {
                    deque.addLast(new int[]{ch, 1});
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        while (!deque.isEmpty()) {
            int[] arr = deque.pollFirst();
                for (int i = 0; i < arr[1]; i++) {
                    builder.append((char)arr[0]);
                }
        }

        return builder.toString();
    }
}
