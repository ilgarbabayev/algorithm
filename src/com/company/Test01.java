package com.company;


import java.io.IOException;
import java.util.Arrays;

public class Test01 {

    public static void main(String[] args) throws IOException {
        System.out.println(factorial(100));
    }

    private static int factorial(int num) {
        if (num == 0) return 1;

        return num * factorial(num - 1);
    }
}




