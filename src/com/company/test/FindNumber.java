package com.company.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindNumber {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> correctList = new HashMap();

        IntStream.range(1,5).forEach(i -> {
            list.add(new Random().nextInt(6) + 1);
        });

        System.out.println(list);

//        Scanner in = new Scanner(System.in);



//        while (correctList.size()<6) {
//            String s = in.nextLine();
//            System.out.println(s);

//            List<Integer> response = Arrays.stream(s.split(",")).map(Integer::valueOf).collect(Collectors.toList());
//            System.out.println(response);
            List<Integer> response = Arrays.stream("1,2,3,4".split(",")).map(Integer::valueOf).collect(Collectors.toList());

        System.out.println(response);

            List<String> playerResponse = new ArrayList<>();

            for(int i = 0; i<4; i++) {
                if (list.get(i).equals(response.get(i))){
                    playerResponse.add("B");
                } else if (list.contains(response.get(i))) {
                    playerResponse.add("W");
                } else {
                    playerResponse.add("E");
                }
            }

            System.out.println("before sort: " + playerResponse);

            List<String> sorted = playerResponse.stream().sorted((a,b) -> {
                if (a.equals("B") || b.equals("B")) {
                    return a.compareTo(b);
                } else {
                    return b.compareTo(a);
                }
            }).collect(Collectors.toList());

            System.out.println("after sort: " + sorted);


            System.out.println(correctList);
            Integer.compare(1,2);
//        }
    }

}
