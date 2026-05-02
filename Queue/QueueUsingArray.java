package Queue;

class QueueB{
    private int arr[];
    private int rear;

    public QueueB(int n){
        arr = new int[n];
        rear = -1;
    } 

    public void add(int data){
        if(rear == arr.length-1){
            System.out.println("Queue is full");
            return;
        }
        arr[++rear] = data; 
    }

    public int peek(){
        if(rear == -1){
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return arr[0];
    }

    public int remove(){
        if(rear == -1){
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int data = arr[0];
        for(int i=0; i<rear; i++){
            arr[i]=arr[i+1];
        }

        rear--;
        return data;
    }

    public boolean isEmpty(){
        return rear==-1;
    }
    
}

public class QueueUsingArray {
    public static void main(String[] args) {
        QueueB q = new QueueB(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        // q.add(6);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

        q.remove();
        System.out.println(q.isEmpty());
    }
}
