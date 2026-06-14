package DP;

public class CountMountainRange {
    public static int countMountain(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<= i-1; j++){
                int minPos = dp[j];
                int rightPos = dp[i-j-1];

                dp[i] += minPos*rightPos;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(countMountain(3));
    }
}
