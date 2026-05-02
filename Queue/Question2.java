package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Question2 {
    public static void main(String[] args) {
        String str = "aabccxb";
        Queue<Character> q = new LinkedList<>();

        int freq[] = new int[26];

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if(!q.isEmpty()){
                System.out.println(q.peek());
            }else{
                System.out.println("-1");
            }
        }
    }
}

