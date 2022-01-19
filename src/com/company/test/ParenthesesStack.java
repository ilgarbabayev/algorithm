package com.company.test;

import java.util.*;

public class ParenthesesStack {

//    private static final Map<String, String> MAP = Map.of(")", "(", "}", "{", "]", "[");
    private static final Map<String, String> MAP = new HashMap<>();

    public static void main(String[] args) {
        MAP.put(")", "(");
        MAP.put("}", "{");
        MAP.put("]", "[");
        List<String> list = List.of("{}()",
                "({()})",
                "{}(",
                "[]");

        list.forEach(ParenthesesStack::isCorrect);

    }

    public static boolean isCorrect(String str) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.size() > 0
                    && MAP.get(Character.toString(str.charAt(i))) != null
                    && MAP.get(Character.toString(str.charAt(i))).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(Character.toString(str.charAt(i)));
            }

        }

        System.out.println(stack + " - " + stack.isEmpty());

        return stack.isEmpty();
    }
}
