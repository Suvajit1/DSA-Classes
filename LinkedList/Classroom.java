package LinkedList;

public class Classroom {

    static class LinkedList {
        static class Node {
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        Node head;
        Node tail;
        int size ;

        public Node addFirst(int data){ // O(1)
            Node temp = new Node(data);
            temp.next = head;

            if(head == null){
                tail = temp;
            }
            head=temp;
            size++;

            return head;
        }

        public void print(){ // O(n)
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data+"-->");
                curr = curr.next;
            }
            System.out.println("null");
        }

        public Node addLast(int data){
            Node temp = new Node(data);
            // Node curr = head;
            // while (curr.next !=null) {   // O(n)
            //     curr = curr.next;
            // }

            // curr.next = temp;
            // return head;

            if(tail == null){   // O(1)
                return addFirst(data);
            }

            tail.next = temp; 
            tail = temp;
            size++;
            return head;
        }

        public Node add(int data, int idx){
            Node temp = new Node(data);
        
            if(idx==0 || size==0){
                return addFirst(data);
            }

            Node currNode = head, nextNode = head.next;
            
            for(int i=0; i<idx-1; i++){
                currNode = currNode.next;
                nextNode = nextNode.next;
            }

            currNode.next = temp;
            temp.next = nextNode;
            size++;

            return head;
        }

        public Node removeFirst(){
            if(size==0){
                return null;
            }

            Node curr = head;
            head = head.next;
            curr.next = null;
            size--; 

            return head;
        }

        public Node removeLast(){
            if (size==0) {
                return null;
            }

            Node curr = head;
            while (curr.next !=tail) {
                curr = curr.next;
            }

            tail = curr;
            tail.next = null;
            size--;

            return head;
        }

        public Node remove(int idx){

            if (idx==0) {
                return removeFirst();
            }
            Node curr = head;

            for(int i=0; i<idx-1; i++){
                curr = curr.next;
            }

            Node nextNode = curr.next;

            curr.next = nextNode.next;
            nextNode.next = null;
            size--;

            return head;
        }

        public int search(Node curr, int key, int i){
            if(curr == null){
                return -1;
            }

            if(curr.data == key){
                return i;
            }

            return search(curr.next, key, i+1);
        }

        public Node reverse(){
            Node prev = null, next = null, curr = head;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            tail = head;
            head = prev;

            return head;
        }

        public int deleteNthNodeFormEnd(int n){
            if(n==size){
                int deleteData = head.data;
                removeFirst();
                return deleteData;
            }

            Node curr = head;
            for(int i=0; i<size-n-1; i++){
                curr=curr.next;
            }

            int data = curr.next.data;
            curr.next = curr.next.next;

            return data;
        }

        // slow fast approach to check palindrom
        public boolean chechPalindrom(){
            Node slow = head, fast = head, mid =null;

            // step 1 - to find mid 
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            mid = slow;

            // step 2 - reverse 2nd half
            Node prev = null, next = null, curr = mid;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // step 3 - checking
            while (tail != null) {
                if(head.data != tail.data){
                    return false;
                }
                head = head.next;
                tail = tail.next;
            }

            return true;
        }

        public boolean detectCycle(){
            Node slow = head, fast = head;

            while (fast != null && fast.next !=null) {
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                    return true;
                }
            }

            return false;
        }


        public void removeCycle(){
            Node slow = head, fast = head;
            boolean cycle = false;

            while (fast != null && fast.next !=null) {
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                    slow = head;
                    cycle = true;
                    break;
                }
            }

            if(cycle == false){
                return;
            }

            // step 2 - remove cycle 
            Node prev = null;

            while (slow != fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }

            prev.next = null;
        }

        public Node mergeSort(Node head){

            if(head == null || head.next == null){
                return head;
            }

            // step 1 - find mid
            Node mid = findMid(head);

            // step 2 - recursive call for lh, rh
            Node left = head;
            Node right = mid.next;
            mid.next = null;

            Node leftH = mergeSort(left);
            Node rightH = mergeSort(right);

            // step 3 - merge
            return merge(leftH, rightH);

        }

        public Node findMid(Node head){
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        public Node merge(Node leftHead, Node rightHead){
            Node temp = new Node(-1);
            Node newHead = temp;

            while (leftHead != null && rightHead != null) {
                if(leftHead.data < rightHead.data){
                    temp.next = leftHead;
                    leftHead = leftHead.next;
                    temp = temp.next;
                }else{
                    temp.next = rightHead;
                    rightHead = rightHead.next;
                    temp = temp.next;
                }
            }

            if (leftHead != null) {
                temp.next = leftHead;
            }

            if(rightHead != null){
                temp.next = rightHead;
            }

            temp = newHead;
            newHead = newHead.next;
            temp.next = null;

            return newHead;
        }

        public void zigzagLL(){
            // mid
            Node mid = findMid(head);

            // reverse 
            Node prev = null, next, curr = mid.next;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            mid.next = null;

            Node leftH = head;
            Node rightH = prev;

            Node nextLeftH, nextrightH;

            while (rightH != null) {
                nextLeftH = leftH.next;
                nextrightH = rightH.next;

                leftH.next = rightH;
                rightH.next = nextLeftH;

                leftH = nextLeftH;
                rightH = nextrightH;
            }
        }
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.add(50, 2);
        ll.add(40, 0);

        ll.print();
        
        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print();

        // ll.remove(1);

        System.out.println(ll.search(ll.head, 100, 0));

        ll.reverse();
        ll.print();

        System.out.println(ll.deleteNthNodeFormEnd(5));
        ll.print();

        System.out.println(ll.chechPalindrom());

        LinkedList ll1 = new LinkedList();
        ll1.addLast(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(2);
        ll1.addLast(1);

        ll1.print();
        System.out.println(ll1.chechPalindrom());


        LinkedList ll2 = new LinkedList();
        ll2.addLast(1);
        ll2.addLast(2);
        ll2.addLast(3);
        ll2.addLast(4);
        ll2.addLast(5);
        ll2.addLast(6);
        ll2.addLast(7);
        ll2.addLast(8);

        ll2.print();

        LinkedList.Node temp = ll2.head.next.next;
        // System.out.println(temp.data);
        ll2.tail.next = temp; 
        // ll2.print();

        System.out.println(ll2.detectCycle());

        ll2.removeCycle();
        ll2.print();
        ll2.removeCycle();
        ll2.print();


        LinkedList ll3 = new LinkedList();
        ll3.addFirst(1);
        ll3.addFirst(2);
        ll3.addFirst(3);
        ll3.addFirst(4);
        ll3.addFirst(5);
        // ll3.addFirst(6);

        ll3.print();

        ll3.head = ll3.mergeSort(ll3.head);
        ll3.print();

        ll3.zigzagLL();
        ll3.print();


    }
}
