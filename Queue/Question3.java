package Queue;

import java.util.LinkedList;
import java.util.Deque;

public class Question3 {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(1);
        dq.addLast(2);
        dq.addFirst(3);
        System.out.println(dq);

        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
    }
}
