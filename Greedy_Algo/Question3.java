package Greedy_Algo;

import java.util.Comparator;
import java.util.Arrays;

// fractional knapsack
public class Question3 {
    public static void main(String[] args) {
        int wt[] = {30, 10 ,20};
        int price[] = {120, 60 ,100};
        int W = 50;

        // int[][] items = {{30, 120}, {10, 60}, {20, 100}}; 

        int profit = 0;
        int n = price.length; 
        Integer bag[][] = new Integer[n][3];

        for(int i=0; i<n; i++){
            bag[i][0] = i;
            bag[i][1] = wt[i];
            bag[i][2] = (int)price[i]/wt[i];
        }

        Arrays.sort(bag, Comparator.comparingDouble(o->o[2]));  // Lambda function
        // ase order

        for(int i=n-1; i>=0; i--){
            int w = bag[i][1];
            int ppw = bag[i][2];
            if(W > w){
                W = W-w;
                profit = profit + w*ppw;
            }else{
                profit += W*ppw;
                break;
            }
        }

        System.out.println(profit);
    }
}
