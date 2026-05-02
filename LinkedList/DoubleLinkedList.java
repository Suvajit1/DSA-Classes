package LinkedList;

public class DoubleLinkedList {
    static class DoubleLL {
        class Node{
            int data;
            Node next;
            Node prev;

            Node(int data){
                this.data =data;
                next = prev = null;
            }
        }

        int size = 0;
        Node head = null;
        Node tail = null; 

        public void addFirst(int data){
            Node temp = new Node(data);

            if(size == 0){
                head = tail = temp;
            }

            temp.next = head;
            head.prev = temp;
            head = temp;
            size++;
        }

        public void addLast(int data){
            Node temp = new Node(data);

            if(size == 0){
                head = tail = temp;
            }

            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            size++;
        }

        public void print(){
            Node curr = head;
            System.out.print("null<---");
            while (curr.next !=null) {
                System.out.print(curr.data+"<==>");
                curr = curr.next;
            }
            System.out.println(curr.data+"--->null");
        }

        public int removeFirst(){
            Node temp = head;

            head = head.next;
            head.prev = null;

            temp.next = null;

            return temp.data;
        }
        
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);

        dll.print();

        System.out.println(dll.removeFirst());
        dll.print();
        

    }
}
