package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test01 {

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> deque = new LinkedList<>(new ArrayList<>(List.of(5,9,8,2,3,6,4,7)));

        for (int i = 0; i < deque.size(); i++) {
            Integer value = deque.get(i);
            if (value % 2 == 0) {

            }
        }
    }
}

