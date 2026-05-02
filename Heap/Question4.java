package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Question4 {
    static class Info implements Comparable<Info>{
    
        int data;
        int idx;

        Info(int data, int idx){
            this.data = data;
            this.idx = idx;
        }

        public int compareTo(Info i2){
            return i2.data - this.data;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, -1, 1, 2, 5, 2 , 1, 3 };
        int k = 3;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        ArrayList<Integer> max = new ArrayList<>();

        for(int i=0; i<k; i++){
            pq.add(new Info(arr[i], i));
        }
        max.add(pq.peek().data);

        for(int si=1; si<arr.length-k+1; si++){
            int ei=si+k-1;
            pq.add(new Info(arr[ei], ei));

            while (pq.peek().idx < si) {
                pq.remove();
            }
            max.add(pq.peek().data);
        }
        System.out.println(max);
    }
}
