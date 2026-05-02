package Hashing;

import java.util.HashMap;

public class Question7 {
    public static void main(String[] args) {
        int arr[] = {2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 5;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
            if(map.containsKey(sum - k)){
                ans++;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);
        System.out.println(map);
    }
}
