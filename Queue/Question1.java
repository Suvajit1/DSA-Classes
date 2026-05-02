package Queue;

import java.util.LinkedList;
import java.util.Queue;

// interleave
public class Question1 {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();

        for(int i=1; i<=10; i++){
            q1.add(i);
        }

        Queue<Integer> q2 = new LinkedList<>();

        int size = q1.size()/2;

        for(int i=0; i<size; i++){
            q2.add(q1.remove());    // 1,2,3,4,5
        }

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
            q1.add(q1.remove());
        }


        while (!q1.isEmpty()) {
            System.out.print(q1.remove()+", ");
        }
        System.out.println();
    }
}
