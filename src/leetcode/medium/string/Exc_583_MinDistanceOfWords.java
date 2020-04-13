package leetcode.medium.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_583_MinDistanceOfWords
 * Author:   Xu Qinkun
 * Date:     2020/4/13 9:15
 * Description:
 */

public class Exc_583_MinDistanceOfWords {

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Exc_583_MinDistanceOfWords mw = new Exc_583_MinDistanceOfWords();
        System.out.println(mw.minDistance("sea", "eat"));
    }
}
