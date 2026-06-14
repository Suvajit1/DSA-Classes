package DP;

import java.util.Arrays;

public class Fibonacci {
    // DP - Memorisation
    public static int fibMemorisation(int n, int[] f){
        if(n==0 || n==1){
            return n;
        }

        if(f[n] != -1){
            return f[n];
        }

        f[n] = fibMemorisation(n-1, f) + fibMemorisation(n-2, f);
        return f[n];
    }

    // DP - Tabutation
    public static int fibTabulation(int n){
        // Step 1 : Create DP table
        int[] dp = new int[n+1];

        // Step 2 : Initialisation
        if(n>0){
            dp[1] = 1;
        }

        // Step 3 : calculation
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n  = 8;
        int f[] = new int[n+1]; // 0
        Arrays.fill(f, -1);

        // f[0] = 0;
        // f[1] = 1;

        int ans = fibMemorisation(n, f);

        ans = fibTabulation(0);

        System.out.println(ans);
   }
}
