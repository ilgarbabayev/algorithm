package com.company.util;

import com.company.handler.OutOfBound;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverter {

    private static final String SPLITTER_OF_LIST = "-----";
    private static final String SPLITTER_OF_VALUES = " ";

    public static List<Integer> getIntList(String fileName, int row) {
        String path = "./src/resources/" + fileName;
        System.out.println(path);
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get(path))
                    .stream()
                    .filter(s -> !s.equals(SPLITTER_OF_LIST))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (row < 0 || row > list.size()) {
            throw new OutOfBound("Row should be in interval 0 < row < " + list.size());
        }

        return convertToInteger(list.get(row - 1));
    }

    private static List<Integer> convertToInteger(String data) {
        return Arrays.stream(data.split(SPLITTER_OF_VALUES)).map(Integer::valueOf).collect(Collectors.toList());
    }
}
