package com.company.test;

import java.util.stream.IntStream;

public class Test {
    /*
    If we list all the natural odd numbers that are multiples of 7,
    then we get 7, 21, 35, ...
    Find the sum of all such numbers those are below 100.
    */
    public static void main(String[] args) {
        int i = IntStream.range(1,101).filter(x-> {
            return x%2!=0 && x%7==0;
        }).sum();

        int z = IntStream.iterate(7, y -> y+14).limit(100/14).sum();

        System.out.println(i);
        System.out.println(z);

    }
}
