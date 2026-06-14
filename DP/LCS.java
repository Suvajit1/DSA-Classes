package DP;
import java.util.Arrays;


public class LCS {

    public static int lcsRecursion(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + lcsRecursion(str1, str2, n - 1, m - 1);
        } else {
            int ans1 = lcsRecursion(str1, str2, n - 1, m);
            int ans2 = lcsRecursion(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    public static int lcsMemorisation(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }
        else{
            if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
                return dp[n][m] = lcsMemorisation(str1, str2, n-1, m-1, dp) + 1;
            } else {
                return dp[n][m] = Math.max(lcsMemorisation(str1, str2, n, m-1, dp), lcsMemorisation(str1, str2, n-1, m, dp));
            }
        }
    }

    public static int lcsTabulation(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        // Step 1 : table creation
        int dp[][] = new int[n+1][m+1];

        // Step 2 : initialisation

        // Step 3 : fill
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // print table
        for(int i = 0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge", str2 = "abedg";

        int n = str1.length();
        int m = str2.length();

        // recursion
        System.out.println(lcsRecursion(str1, str2, n, m));

        // Memorisaton
        int dp[][] = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(lcsMemorisation(str1, str2, n, m, dp));

        for(int i = 0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        // tabulation
        System.out.println(lcsTabulation(str1, str2));
    }
}
