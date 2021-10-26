package leetcode.medium.dp;

public class Exc_005_LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1, begin = 0;
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j >= len) break;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Exc_005_LongestPalindrome lp = new Exc_005_LongestPalindrome();
//        System.out.println(lp.longestPalindrome("a"));
//        System.out.println(lp.longestPalindrome("babad"));
//        System.out.println(lp.longestPalindrome("cbbd"));
        System.out.println(lp.longestPalindrome("ac"));
    }
}
