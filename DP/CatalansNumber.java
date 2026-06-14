package DP;

public class CatalansNumber {

    public static long catalan(int n){
        long dp[] = new long [n+1];

        // initilisation 
        dp[0] = dp[1] = 1;

        // fill
        // T.C. = O(n^2);
        for(int i=2; i<=n; i++){
            for(int j=0; j<= i-1; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }

    public static long cat(int n){
        long dp[] = new long[n+1];

        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = (4*i-2)*dp[i-1]/(i+1);
        }
        
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(catalan(10));
        System.out.println(cat(10));
    }
}
