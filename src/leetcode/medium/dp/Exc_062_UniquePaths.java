package leetcode.medium.dp;

public class Exc_062_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }
        dp[0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Exc_062_UniquePaths up = new Exc_062_UniquePaths();
        System.out.println(up.uniquePaths(3, 2));
        System.out.println(up.uniquePaths(3, 3));
        System.out.println(up.uniquePaths(3, 7));
    }
}
