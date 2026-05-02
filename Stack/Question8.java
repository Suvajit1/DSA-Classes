package Stack;

import java.util.Stack;

public class Question8 {
    public static boolean isDuplicate(String str){
        Stack<Character> s =new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch != ')'){
                s.push(ch);
            }else{ // closing bracket
                int count = 0;
                while (s.pop() !='(') {
                    count++;
                }

                if(count<1){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str1 = "((a+b)+(c+d))";

        System.out.println(isDuplicate(str1));
    }
}
