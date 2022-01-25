package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test01 {

    public static void main(String[] args) throws IOException {
        List<Integer> list = List.of(0,1,2,3,4,5,6,7,8,9);
        list.forEach(i -> {
            System.out.println(( i * ( i - 1)) / 2);
        });

    }
}

