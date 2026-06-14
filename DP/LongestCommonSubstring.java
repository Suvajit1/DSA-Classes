package DP;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        //  Step 1 : Table Creation
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        // Step 2: Initialize (already 0 by default in Java)

        // Step 3: Fill the table
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        // Print table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s2 ="xyzabcdef", s1 = "abcdxyze";

        System.out.println(longestCommonSubstring(s1, s2));
    }
}
