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

        int row = 3;
        int k = map.get(row);

        try {
            list = DataConverter.getIntList("radio_transmitter.txt", row);
        }catch (OutOfBound e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(hackerlandRadioTransmitters(list, k));
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        int count = 0;

        Collections.sort(x);
        System.out.println(x);

        int i = 0;

        while (i < x.size()){
            Integer toCompare = x.get(i);

            while (i < x.size() && toCompare + k >= x.get(i)){
                i++;
            }

            toCompare = x.get(i - 1);

            while (i < x.size() && toCompare + k >= x.get(i)) {
                i++;
            }
            count++;
        }
        return count == 0 ? 1 : count;
    }
}
