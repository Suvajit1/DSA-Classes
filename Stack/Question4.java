package Stack;

import java.util.Stack;

// next greater elemeent from right
public class Question4 {

    public static void nextGreaterRight(int arr[]){
        int nextGreater[] = new int[arr.length];
        Stack<Integer> s = new Stack<>(); // store idx
        
        for(int i=arr.length-1; i>=0; i--){     // O(n)
            // for each element there is two call 3 call (peek, pop, push)
            // 1
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2
            if(s.isEmpty()){
                nextGreater[i] = -1;
            } else{
                nextGreater[i] = arr[s.peek()];
            }

            // 3
            s.push(i);
        }

        // print next greater
        for(int i = 0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3, 2, 5};

        nextGreaterRight(arr);
    }
}
