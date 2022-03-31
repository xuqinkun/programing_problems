package leetcode.medium.dp;

public class Exc_516_LongestPalindromeSubseq {

    public static void main(String[] args) {
        Exc_516_LongestPalindromeSubseq lp = new Exc_516_LongestPalindromeSubseq();
        System.out.println(lp.longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
