package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Question {
    public static boolean anagram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(map.get(c) != null){
                if(map.get(c) == 1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c)-1);
                }
            }else{
                return false;
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        // mejority element
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1, 3, 3};
        HashMap<Integer, Integer> nums = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            nums.put(arr[i], nums.getOrDefault(arr[i], 0)+1);
        }

        // System.out.println(nums);
        for(Integer val : nums.keySet()){
            if(nums.get(val) > arr.length/3){
                System.out.println(val);
            }
        }

        // valid anagram
        String s = "race", t = "care";
        System.out.println(anagram(s, t));

        // hashSet
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }

        System.out.println(set);

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();

        for(Integer i : set){
            System.out.print(i+" ");
        }
        System.out.println();

        // union and Intersection 
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }
        ArrayList<Integer> intersection = new ArrayList<>();
        for(int i : arr2){
            if(hs.remove(i)){
                intersection.add(i);
            }
        }

        System.out.println(intersection);

        for(int i : arr2){
            hs.add(i);
        }
        System.out.println(hs);

        // itenerary
        String ticket[][] = {{"Chennai", "Bengaluru"}, {"Mumbai", "Delhi"}, {"Goa", "Chennai"}, {"Delhi", "Goa"}}; // from to

        HashMap<String, String> fromtoMap = new HashMap<>();
        HashMap<String, String> tofromMap = new HashMap<>();

        for(int i=0; i<ticket.length; i++){
            fromtoMap.put(ticket[i][0], ticket[i][1]);
            tofromMap.put(ticket[i][1], ticket[i][0]);
        }

        String src = "";
        for(String stop : fromtoMap.keySet()){
            if(tofromMap.containsKey(stop) == false){
                src = stop;
            }
        }

        System.out.print(src);

        while (!fromtoMap.isEmpty()) {
            String dest = fromtoMap.remove(src);
            System.out.print("-->"+dest);
            src = dest;
        }
        System.out.println();
    }
}
