package Stack;
import java.util.Stack;
// Reverse a string using Stack

public class Question2 {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder newStr = new StringBuilder();
        while (!s.isEmpty()) {
            newStr.append(s.pop());
        }

        return newStr.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseString("abcd"));
        System.out.println(reverseString("hello world"));

    }
}
