package com.company.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueStudent {
    public static void main(String[] args) {

        List<String> events = List.of(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );

        List<Student> list = Priorities.getStudents(events);

        list.forEach(s -> System.out.println(s.getName()));
    }
}

class Priorities {
    public static ArrayList<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>();
        events.forEach(s -> {
            String[] array = s.split(" ");
            if (array.length > 1) {
                queue.add(new Student(array[1], Double.valueOf(array[2]), Integer.valueOf(array[3])));
                System.out.println(queue);
            } else {
                queue.poll();
            }
        });

        ArrayList<Student> list = new ArrayList<>();
        while (queue.size() > 0) {
            list.add(queue.poll());
        }

        return list;
    }
}

class Student implements Comparable<Student>{
    String name;
    Double cgpa;
    Integer id;

    public Student(String name, Double cgpa, Integer id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.cgpa.equals(o.cgpa)) {
            if (this.name.compareTo(o.name) == 0) {
                return Integer.compare(id, o.id);
            } else {
                return this.name.compareTo(o.name);
            }
        } else {
            return o.cgpa.compareTo(this.cgpa);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cgpa=" + cgpa +
                ", id=" + id +
                '}';
    }
}
