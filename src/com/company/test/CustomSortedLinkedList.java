package com.company.test;


import java.io.IOException;

public class CustomSortedLinkedList {

    public static void main(String[] args) throws IOException {

        DoubleList doubleList = new DoubleList();
        doubleList.addSorted(4);
        doubleList.addSorted(1);
        doubleList.addSorted(3);
        doubleList.addSorted(5);
        doubleList.addSorted(3);

        System.out.println(doubleList);

    }

    static class DoubleList {

        Node head;

        void addSorted(Integer digit) {

            Node newNode = new Node(digit);

            if (head == null || head.digit >= digit) {
                addToFront(newNode);
                return;
            }

            Node current = head.next;
            Node previous = head;
            while (current != null && current.digit < digit) {
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
            newNode.next = current;
        }

        void addToFront(Node newNode) {
            newNode.next = head;
            head = newNode;
        }

        @Override
        public String toString() {
            String first = head.digit.toString();
            Node node = head.next;
            while (node != null) {
                first += " " + node.digit;
                node = node.next;
            }

            return first;
        }
    }


    static class Node {
        public Node(Integer digit) {
            this.digit = digit;
        }

        Integer digit;
        Node next;
    }
}




