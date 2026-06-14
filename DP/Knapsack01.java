package DP;

import java.util.Arrays;

public class Knapsack01 {

    public static int maxProfitMem(int []price, int []wt, int n, int w, int dp[][]){
        if(n == 0 || w == 0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }

        if(w >= wt[n-1]){
            int incP = price[n-1] + maxProfitMem(price, wt, n-1, w-wt[n-1], dp);
            int excP = maxProfitMem(price, wt, n-1, w, dp);

            return dp[n][w] = Math.max(incP, excP);
        }else{
            return dp[n][w] = maxProfitMem(price, wt, n-1, w, dp);
        }
    }

    public static int maxProfitTabluar(int []price, int []wt, int n, int w){
        int dp[][] = new int[n+1][w+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                int iw = wt[i-1];
                if(iw<=j){
                    dp[i][j] = Math.max(price[i-1] + dp[i-1][j-iw], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
        return dp[n][w];
    }
    public static void main(String[] args) {
        int price[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5 ,1, 3, 4};
        int w = 7;

        int n = price.length;
        
        int dp[][] = new int[n+1][w+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }  
        
        System.out.println(maxProfitMem(price, wt, n, w, dp));

        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(maxProfitTabluar(price, wt, n, w));
    }
}
