package Heap;

import java.util.ArrayList;

public class Cloassroom {
    static class Heap { // min heap
        ArrayList<Integer> arr = new ArrayList<>();
        
        // add()
        public void add(int data){
            arr.add(data);

            // adjust the heap
            int c = arr.size()-1;
            int p = (c-1)/2;

            while (arr.get(c) < arr.get(p)) {
                // swap
                int temp = arr.get(c);
                arr.set(c, arr.get(p));
                arr.set(p, temp);

                // update 
                c = p;
                p = (c-1)/2;
            }
        }

        // remove()
        public int remove(){
            // step 1
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2
            int data = arr.remove(arr.size()-1);

            // step 3
            heapify(0);

            return data;
        }

        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;

            int minIdx = i;

            if(left<arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx = left;
            }
            if(right <arr.size() && arr.get(right) < arr.get(minIdx)){
                minIdx = right;
            }

            // swap
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        // peek()
        public int peek(){
            return arr.get(0);
        }

        // isEmpty()
        public boolean isEmpty(){
            return arr.isEmpty();
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap(); // min Heap
        h.add(10);
        h.add(20);
        h.add(15);
        h.add(30);
        h.add(40);
        h.add(25);
        h.add(45);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
