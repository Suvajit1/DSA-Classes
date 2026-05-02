package Hashing;

import java.util.HashMap;

public class Question1 {
    public static void main(String[] args) {
        // majority Elemant
        int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1, 5};
        HashMap<Integer, Integer> map = new HashMap<>();

        // for(int num : nums){
        //     if(map.containsKey(num)){
        //         map.put(num, map.get(num)+1);
        //     }else{
        //         map.put(num, 1);
        //     }
        // }

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Integer ele : map.keySet()){
            if(map.get(ele) >= nums.length/3){
                System.out.println(ele);
            }
        }
    }
}
