package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test01 {

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.offer(2);
        deque.offer(3);
        deque.size();
        deque.remove();
        deque.remove(2);
        deque.poll();
    }
}

