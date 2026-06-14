package DP;

public class RodCutting {
    
    public static int maxProfit(int[] length, int[] price, int rodLength){
        int n = length.length;
        // Step 1 : Table creation
        int dp[][] = new int[n+1][rodLength+1]; 

        // Step 2 : Initialisation

        // Step 3 : Fill
        for(int i=1; i<n+1; i++){
            for(int j=1; j<rodLength+1; j++){
                int l = length[i-1];
                if(l <= j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-l], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // print
        for(int i=0; i<n+1; i++){
            for(int j=0; j<rodLength+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n][rodLength];
    }
    public static void main(String[] args) {
        int rodLength = 8;
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(maxProfit(length, price, rodLength));

    }
}
