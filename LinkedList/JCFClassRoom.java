package LinkedList;

import java.util.LinkedList;

public class JCFClassRoom {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        // add last
        ll.add(1);
        ll.add(2);
        ll.add(3);

        ll.addFirst(4);

        ll.add(2, 5);

        ll.set(2, 10);

        // remove first
        ll.remove();

        ll.remove(2);

        System.out.println(ll);
    }
}
