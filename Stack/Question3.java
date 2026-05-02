package Stack;
// reverse a Stack 
// without using extra space

import java.util.Stack;

public class Question3 {
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverse(s);
        pushAtBottom(s,top);
    }

    public static void pushAtBottom(Stack<Integer> s, int top){
        if(s.isEmpty()){
            s.push(top);
            return;
        }

        int x = s.pop();
        pushAtBottom(s, top);
        s.push(x);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
