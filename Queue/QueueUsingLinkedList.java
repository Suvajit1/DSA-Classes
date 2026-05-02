package Queue;

class Queue {
    static class Node {
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    public boolean isEmpty(){
        return front == null;
    }

    public void add(int data){
        Node temp = new Node(data);

        if(front == null){
            front = rear = temp;
        }

        rear.next = temp;
        rear = temp;
    }


    public int remove(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }

        Node temp = front;
        front = front.next;
        temp.next = null;

        return temp.data;
    }

    public int peek(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }

        return front.data;
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
