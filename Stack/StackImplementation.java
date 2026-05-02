package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackImplementation {
    static class StackAL{
        ArrayList<Integer> list = new ArrayList<>();

        public void push(int data){
            list.add(data);
        }

        public int peek(){
            return list.get(list.size()-1);
        }

        public int pop(){
            return list.remove(list.size()-1);
        }

        public boolean isEmpty(){
            return list.size()==0;
        }
    } 
    
    static class StackLL {
        class Node{
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        Node top;

        public void push(int data){     // O(1)
            Node temp = new Node(data);

            if (top == null) {
                top = temp;
                return;
            }

            temp.next = top;
            top = temp;
        }

        public int pop(){   // O(1)
            if(top==null){
                return -1;
            }

            Node temp = top;

            top = top.next;
            temp.next = null;

            return temp.data;
        }

        public int peek(){  // O(1)
            if (top == null) {
                return -1;
            }
            return top.data;
        }

        public boolean isEmpty(){
            return top == null;
        }    
    }

    public static void main(String[] args) {
        StackLL s = new StackLL();

        s.push(2);
        s.push(3);
        s.push(6);
        s.push(10);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        Stack<Integer> st = new Stack<>();

        st.push(2);
        st.push(4);
        st.push(6);
        st.push(8);
        st.push(10);

        System.out.println(st);

        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }

    }
}
