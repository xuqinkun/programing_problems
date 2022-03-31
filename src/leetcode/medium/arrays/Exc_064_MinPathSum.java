package leetcode.medium.arrays;

public class Exc_064_MinPathSum {

    public static void main(String[] args) {
        Exc_064_MinPathSum mp = new Exc_064_MinPathSum();
        System.out.println(mp.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0)
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (i > 0 && j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (i > 0)
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
