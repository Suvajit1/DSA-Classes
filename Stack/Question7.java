package Stack;

import java.util.Stack;

// valid Parenthesis
public class Question7 {
    public static boolean isValidParenthesis(String str){
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            // open Bracket
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            // closing Bracket
            else if(!s.isEmpty() && (ch == ')' && s.peek()== '(') || 
                    (ch == '}' && s.peek() == '{') ||
                    (ch == ']' && s.peek() == '[')){
                        s.pop();
            } else{
                return false;
            }
        }

        if(!s.isEmpty()){ 
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        String str1 = "({[]}())";
        String str2 = "({[]})";
        String str3 = "{)(";
        String str4 = "({[";

        System.out.println(isValidParenthesis(str1));
        System.out.println(isValidParenthesis(str2));
        System.out.println(isValidParenthesis(str3));
        System.out.println(isValidParenthesis(str4));
        System.out.println(isValidParenthesis(""));

    }
}
