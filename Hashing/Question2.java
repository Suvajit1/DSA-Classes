package Hashing;

import java.util.HashMap;

public class Question2 {
    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> hs = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(!hs.containsKey(c)){
                return false;
            }else{
                hs.put(c, hs.get(c)-1);
                if(hs.get(c)==0){
                    hs.remove(c);
                }
            }
        }

        return hs.isEmpty();
    }
    public static void main(String[] args) {
        // valid Anagram
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
