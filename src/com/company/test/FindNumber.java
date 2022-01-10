package com.company.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindNumber {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        IntStream.range(1,5).forEach(i -> {
            list.add(new Random().nextInt(6) + 1);
        });

        System.out.println(list);

//        Scanner in = new Scanner(System.in);

//        Map<Integer,Integer> correctList = new HashMap<>();
//        while (correctList.size()<6) {
//            String s = in.nextLine();
//            System.out.println(s);

//            List<Integer> response = Arrays.stream(s.split(",")).map(Integer::valueOf).collect(Collectors.toList());
//            System.out.println(response);
        List<Integer> response = Arrays.stream("1,2,4,4".split(",")).map(Integer::valueOf).collect(Collectors.toList());

        System.out.println(response);

        Map<Integer, Integer> map = new HashMap<>();
        List<String> playerResponse = new ArrayList<>();
        List<Integer> tempResponse = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            Integer keyCoder = list.get(i);
            Integer keyResponse = response.get(i);

            if (keyCoder.equals(keyResponse)){
                playerResponse.add("B");
            } else {
                Integer value = map.getOrDefault(keyCoder, 0);
                map.put(keyCoder, ++value);
                tempResponse.add(keyResponse);
            }
        }

        System.out.println(map);
        System.out.println(tempResponse);

        tempResponse.forEach(r -> {
            Integer value = map.getOrDefault(r, 0);
            if (value > 0) {
                playerResponse.add("W");
                map.put(r, --value);
            }
        });

        for (int i = playerResponse.size(); i < 4; i++) {
            playerResponse.add("E");
        }

        System.out.println("response: " + playerResponse);

//        }
    }

}
