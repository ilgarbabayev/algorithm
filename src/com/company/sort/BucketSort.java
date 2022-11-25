package com.company.sort;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) throws IOException {

      int[] intArray = {54, 46, 83, 66, 95, 92, 43};

      bucketSort(intArray);

      System.out.println(Arrays.toString(intArray));

    }

   private static void bucketSort(int[] input) {

     List<Integer>[] buckets = new List[10];

     for (int i = 0; i < buckets.length; i++) {
       buckets[i] = new ArrayList<>();
     }

     for (int i = 0; i < input.length; i++) {
       buckets[hash(input[i])].add(input[i]);
     }

     for (List<Integer> bucket: buckets) {
       Collections.sort(bucket);
     }

     int j = 0;

     for (int i = 0; i < buckets.length; i++) {
       for (int value : buckets[i]) {
         input[j++] = value;
       }
     }
   }

   private static int hash(int value) {
      return value / (int) 10;
   }
}




