package com.axing;

// dp
public class Problem516 {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        // 初始化对角线
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 填充上三角区域
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
