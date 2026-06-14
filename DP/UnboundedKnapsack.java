package DP;

public class UnboundedKnapsack {

    public static int maxProfitUnbounded(int []price, int []wt, int W){
        int n = price.length;

        // Step 1 : initialisation
        int dp[][] = new int[n+1][W+1];

        // Step 2 : initilisation -- done

        // Step 3 : Fill
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int w = wt[i-1];
                if(w <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-w], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // print
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
        return dp[n][W];
    }

    public static void main(String[] args) {
        int price[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5 ,1, 3, 4};
        int W = 7;

        System.out.println(maxProfitUnbounded(price, wt, W));
    }
}
