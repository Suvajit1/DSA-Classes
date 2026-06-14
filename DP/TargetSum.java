package DP;

public class TargetSum {

    public static boolean targetSum(int[] numbers, int sum){
        int n = numbers.length;

        // Step 1 : Table creation
        boolean dp[][] = new boolean[n+1][sum+1];

        // Step 2 : Initilisation + (meaning)
        for(int i=0; i<n+1; i++){
            dp[i][0] = true;
        }

        // Step 3 : fill
        // for(int i=1; i<n+1; i++){
        //     for(int j=1; j<sum+1; j++){
        //         int v = numbers[i-1];
        //         if(v <= j){ 
        //             dp[i][j] = dp[i-1][j-v] || dp[i-1][j];
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                int v = numbers[i-1];
                if(v <= j && dp[i-1][j-v] == true){ 
                    dp[i][j] = true;
                }
                if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }

        // print the dp
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                char c = 'F';
                if(dp[i][j]){
                    c = 'T';
                }
                System.out.print(c+"  ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 3, 1};
        int target = 10;

        System.out.println(targetSum(numbers, target));
    }
}
