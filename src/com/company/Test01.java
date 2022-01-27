package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test01 {

    public static void main(String[] args) throws IOException {
        List<Integer> expenditure = new ArrayList<>(List.of(2, 3, 4, 2, 3, 6, 8, 4, 5));

        Window window   = new Window();

        // **** populate window ****
        for (int i = 0; i < expenditure.size(); i++){
            window.insert(expenditure.get(i));
        }

        System.out.println(window);

        while (!window.largers.isEmpty()){
            System.out.print(window.largers.poll() + " ");
        }
        System.out.println("\n-----------");
        while (!window.smallers.isEmpty()) {
            System.out.print(window.smallers.poll() + " ");
        }
    }

    static class Window {


        // **** ****
        PriorityQueue<Integer> smallers = new PriorityQueue<>((a, b) -> b - a); // decrementing
        PriorityQueue<Integer> largers  = new PriorityQueue<>();                // incrementing


        /**
         * Largers should have size() + 1 of smallers.
         */
        private void adjustSizes() {
            if (smallers.size() > largers.size())
                largers.offer(smallers.poll());
            else if (largers.size() > smallers.size() + 1)
                smallers.offer(largers.poll());
        }


        /**
         *
         */
        public void insert(Integer x) {

            // **** insert x (where needed) ****
            if (largers.isEmpty() || x >= largers.peek())
                largers.offer(x);
            else
                smallers.offer(x);

            // **** ****
            adjustSizes();
        }


        /**
         *
         */
        public void remove(Integer x) {

            // **** ****
            if (x >= largers.peek())
                largers.remove(x);
            else
                smallers.remove(x);

            // **** ****
            adjustSizes();
        }


        /**
         * Compute median from window.
         */
        public double median() {
            if (largers.size() > smallers.size())
                return largers.peek();
            else
                return (smallers.peek() + largers.peek()) /2.0;
        }


        /**
         *
         */
        public String toString() {
            return smallers + " - " + largers;
        }
    }
}

