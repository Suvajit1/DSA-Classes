package Heap;

import java.util.PriorityQueue;

public class PQClass{
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        
        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }

        public String toString(){
            return "("+this.name+", "+this.rank+")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Dhrubo", 15));
        pq.add(new Student("Priyam", 10));
        pq.add(new Student("Suvajit", 20));
        pq.add(new Student("Arpan", 5));

        System.out.println(pq);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
