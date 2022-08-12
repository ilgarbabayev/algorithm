package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test01 {

    public static void main(String[] args) throws IOException {
        int[] tests = {1, 2};
        System.out.println(tests.length);
    }

    static List<Ttt> getTests() {
        var t01 = new Ttt(1L, false);
        var t02 = new Ttt(2L, true);
        var t03 = new Ttt(3L, false);
        var t04 = new Ttt(4L, true);
        var t05 = new Ttt(5L, false);
        var t06 = new Ttt(6L, true);
        var t08 = new Ttt(8L, true);
        var t07 = new Ttt(7L, true);
        var t10 = new Ttt(10L, false);
        var t09 = new Ttt(9L, false);

        return List.of(t01, t02, t03, t04, t05, t06, t08, t07, t10, t09);
    }
}

class Ttt {
    public Ttt(Long id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    Long id;
    boolean isDeleted;

    @Override
    public String toString() {
        return "Ttt{" +
            "id=" + id +
            ", isDeleted=" + isDeleted +
            '}';
    }
}



