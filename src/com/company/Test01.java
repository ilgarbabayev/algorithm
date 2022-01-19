package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) throws IOException {
        Arrays.stream(new File("/Users/ibabayev/Documents").listFiles()).forEach(System.out::println);
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/ibabayev/Documents/test.txt"))) {
            System.out.println("---------------");
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=================");

        Files.readAllLines(Paths.get("/Users/ibabayev/Documents/test.txt")).forEach(System.out::println);

    }
}

