package Stack;

import java.util.Stack;

public class Question5 {
    public static void stackSpan(int price[]){
        int prevHigh[] = new int[price.length]; // idx
        int span[] = new int[price.length];

        Stack<Integer> s = new Stack<>(); // idx

        for(int i=0; i<price.length; i++){
            while (!s.isEmpty() && price[s.peek()] <= price[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                prevHigh[i] = -1;
            }else{
                prevHigh[i] = s.peek();
            }

            s.push(i);
        }

        for(int i=0; i<span.length; i++){
            span[i] = i - prevHigh[i];
        }

        for(int i=0; i<span.length; i++){
            System.out.print(span[i] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int price[] = {100, 80, 60, 70, 60 ,85, 100};

        stackSpan(price);
    }
}
