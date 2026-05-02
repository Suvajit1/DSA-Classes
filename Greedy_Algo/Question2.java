package Greedy_Algo;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        // Indian Coin
        Integer coin[] = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        int amount = 121;

        Arrays.sort(coin, Collections.reverseOrder()); // O(nlogn)
        ArrayList<Integer> useedCoin = new ArrayList<>();
        int count = 0;
        for(int i=0; i<coin.length; i++){
            while (coin[i]<=amount) {
                count++;
                useedCoin.add(coin[i]);
                amount -= coin[i];
            }
        }

        System.out.println(useedCoin);
        System.out.println(count);

    }
}
