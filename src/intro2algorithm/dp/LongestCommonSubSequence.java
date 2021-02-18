package intro2algorithm.dp;

public class LongestCommonSubSequence {

    public static int commonSequence(String s1, String s2, int[][] dp) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
            return 0;
        int len1 = s1.length(), len2 = s2.length();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c = s1.charAt(i - 1);
                if (s2.charAt(j - 1) == c) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "ABCBDAB", s2 = "BDCABA";
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        System.out.println(commonSequence(s1, s2, dp));
        printLCS(dp, s1, len1, len2);
    }

    private static void printLCS(int[][] dp, String s1, int i, int j) {
        if (i <= 0 || j <= 0) return;
        if (dp[i][j] == dp[i - 1][j - 1] + 1) {
            printLCS(dp, s1, i - 1, j - 1);
            System.out.print(s1.charAt(i - 1));
        }
        else if (dp[i][j] == dp[i][j - 1]) {
            printLCS(dp, s1, i, j - 1);
        } else {
            printLCS(dp, s1, i - 1, j);
        }

    }
}
