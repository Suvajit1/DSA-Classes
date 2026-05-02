package Queue;

import java.util.Stack;

public class QueueUnigTwoStack {
    static class QueueTS{
        Stack<Integer> org = new Stack<>();
        Stack<Integer> aux = new Stack<>();

        public void add(int data){ // O(n)
            if(org.isEmpty()){
                org.push(data);
            }else{
                while (!org.isEmpty()) {
                    aux.push(org.pop());
                }
                org.push(data);
                while (!aux.isEmpty()) {
                    org.push(aux.pop());
                }
            }

            // if(!org.isEmpty()){
            //     while (!org.isEmpty()) {
            //         aux.push(org.pop());
            //     }
            //     org.push(data);
            //     while (!aux.isEmpty()) {
            //         org.push(aux.pop());
            //     }

            //     return;
            // }

            // org.push(data);
        }

        public boolean isEmpty(){ // O(1)
            return org.isEmpty();
        }

        public int remove(){ // O(1)
            return org.pop();
        }

        public int peek(){ // O(1)
            return org.peek();
        }
    }
    public static void main(String[] args) {
        QueueTS q = new QueueTS();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
