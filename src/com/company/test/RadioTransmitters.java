package com.company.test;

import com.company.handler.OutOfBound;
import com.company.util.DataConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RadioTransmitters {
    public static void main(String[] args) {
        Map<Integer, Integer> map = Map.of(1, 51,
                2, 2,
                3, 2,
                4, 1,
                5, 1);

        List<Integer> list;

        int row = 1;
        int k = map.get(row);

        try {
            list = DataConverter.getIntList("radio_transmitter.txt", row);
        }catch (OutOfBound e) {
            System.out.println(e.getMessage());
            return;
        }

//        System.out.println(list);

        System.out.println(hackerlandRadioTransmitters(list, k));
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        int count = 0;

        Collections.sort(x);

        System.out.println(x);

        for (int i = 0; i < x.size() - 1;) {
            int current = x.get(i);

            Integer next = x.get(i + 1);

            while (next <= current + k && i < x.size() - 1){
                next = x.get(++i);
            };

            count++;
        }

        return count == 0 ? 1 : count;
    }
}
