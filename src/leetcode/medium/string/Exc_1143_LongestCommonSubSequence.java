package leetcode.medium.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1143_LongestCommonSubSequence
 * Author:   Xu Qinkun
 * Date:     2020/4/13 9:35
 * Description:最长公共子序列
 */

public class Exc_1143_LongestCommonSubSequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Exc_1143_LongestCommonSubSequence lcs = new Exc_1143_LongestCommonSubSequence();
        System.out.println(lcs.longestCommonSubsequence("bc","def"));
    }
}
