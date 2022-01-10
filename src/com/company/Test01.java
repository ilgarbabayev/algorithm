package com.company;


import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Test01 {

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.push("Bir");
        list.push("Iki");
        System.out.println(list.peek());
        System.out.println(list.peek());

        LinkedHashMap<Integer, Integer> lMap = new LinkedHashMap<>();
        lMap.put(2,1);
        lMap.put(1,2);
        System.out.println(lMap);

    }
}

