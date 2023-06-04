package com.peerfintech.algorithm;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/25
 * Time: 20:45
 * Description: leetcode 44 通配符匹配
 */
public class Algorithm7 {
    public static void main(String[] args) {

    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n ; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = false;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
