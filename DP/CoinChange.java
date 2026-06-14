package DP;

public class CoinChange {
    public static int countWays(int[] coins, int sum){
        int n = coins.length;

        int[][] dp = new int[n+1][sum+1]; // table creation

        // Step 2 : Initialisation
        for(int i=0; i<n+1; i++){
            dp[i][0] = 1;
        }

        // Step 3 : Fill
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                int v = coins[i-1];
                if(v <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-v];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
        int sum = 10;
        System.out.println(countWays(coins, sum));
    }
}
