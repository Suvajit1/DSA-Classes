package DP;

public class CountTrees {

    public static int bstCount(int n){
        int dp[] = new int[n+1];

        // initilisation 
        dp[0] = dp[1] = 1;

        // T.C. = O(n^2);
        for(int i=2; i<=n; i++){
            for(int j=0; j<= i-1; j++){
                int left = dp[j];
                int right = dp[i-j-1];

                dp[i] += left*right;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        
        System.out.println(bstCount(5));
    }
}
