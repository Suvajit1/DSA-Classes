package Queue;

class CircularQueue{
    private int arr[];
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int n){
        arr = new int[n];
        front = rear = -1;
        size = arr.length;
    } 

    public boolean isFull(){
        return (rear+1)%size == front;
    }

    public boolean isEmpty(){
        return front==-1 && rear==-1;
    }

    public void add(int data){
        if(isFull()){
            System.out.println("Queue is Full");
        }

        if(front == -1){
            front = 0;
        }
        rear = (rear+1)%size;
        arr[rear] = data;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int data = arr[front];

        if(rear == front){
            front = rear = -1;
        }else{
            front = (front+1)%size;
        }

        return data;
    }
    
}
public class CircularQueueUsingArray {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);

        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.remove();
        cq.remove();
        cq.add(4);
        cq.add(5);

        while (!cq.isEmpty()) {
            System.out.println(cq.peek());
            cq.remove();
        }        
    }
}
