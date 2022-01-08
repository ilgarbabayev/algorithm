package com.company.test;

import java.util.*;
import java.util.stream.*;

class Result {
    public static int hourglassSum(List<List<Integer>> arr) {
        arr.forEach(a-> {
            a.forEach(aa-> {
                if(aa>=0) {
                    System.out.print(" " + aa + "\t");
                } else {
                    System.out.print(aa + "\t");
                }

            });
            System.out.println();
        });

        int z = 0;
        int zz = Integer.MIN_VALUE;
        for (int xx = 0; xx <=3; xx++) {
            for (int yy=0; yy<=3; yy++) {
                for (int x=xx; x <= xx+2; x++) {
                    for (int y = yy; y<=yy+2; y++) {
                        if (x==xx+1) {
                            if(y==yy+1) {
                                z += arr.get(x).get(y);
                            }
                        } else {
                            z += arr.get(x).get(y);
                        }
                    }
                }
                if (zz < z) zz = z;
                z = 0;
            }
        }
        return zz;
    }
}

public class HourGlass {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> arr.add(IntStream.range(0,6).mapToObj(ii -> new Random().nextInt(19) - 9).collect(Collectors.toList())));
        System.out.println(Result.hourglassSum(arr));
    }
}
