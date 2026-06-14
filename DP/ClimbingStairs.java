package DP;

public class ClimbingStairs {
    public static int countWays(int n){
        int[] dp = new int[n+1]; // table creation
        
        for(int i=1; i<n+1; i++){
            if(i <= 2){ // initialisation
                dp[i] = i;
            }else{
                dp[i] = dp[i-1] + dp[i-2]; // calculation
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
}
