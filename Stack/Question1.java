package Stack;
// pust at the buttom of the stack

import java.util.Stack;

public class Question1 {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int x = s.pop();
        pushAtBottom(s, data);
        s.push(x);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s); // 1,2,3 // entry order
        // pop order
        // 3, 2, 1

        pushAtBottom(s, 4);
        System.out.println(s); // 4,1,2,3 

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
