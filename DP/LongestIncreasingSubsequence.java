package DP;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lis(int[] arr){
        int sortedArr[] = new int[arr.length];
        sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        int n = arr.length;
        int dp[][] = new int[n+1][n+1]; // step 1 : table Creation

        // Step 2 : initialisation -- done 

        // Ste 3 : Fill
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(arr[i-1] == sortedArr[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};

        System.out.println(lis(arr));
    }
}
