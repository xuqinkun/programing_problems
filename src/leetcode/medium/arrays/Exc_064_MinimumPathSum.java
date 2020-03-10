package leetcode.medium.arrays;

public class Exc_064_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        if (rowSize == 0) return 0;
        int colSize = grid[0].length;
        if (colSize == 0) return 0;

        int []dp = new int[colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                }
                else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                }
                else if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                }
                else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colSize - 1];
    }

    public static void main(String[] args) {
        Exc_064_MinimumPathSum mps = new Exc_064_MinimumPathSum();
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(mps.minPathSum(a));
    }
}
