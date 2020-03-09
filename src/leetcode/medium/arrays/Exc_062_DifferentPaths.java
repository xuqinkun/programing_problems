package leetcode.medium.arrays;

public class Exc_062_DifferentPaths {
    private int uniquePaths(int m, int n, int paths[][]) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        if (paths[m][n] != 0) return paths[m][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 || j != 1) {
                    paths[i][j] = uniquePaths(i - 1, j, paths) + uniquePaths(i, j - 1, paths);
                }
            }
        }
        return paths[m][n];
    }

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m + 1][n + 1];
        paths[1][1] = 1;
        return uniquePaths(m, n, paths);
    }

    public static void main(String[] args) {
        Exc_062_DifferentPaths dp = new Exc_062_DifferentPaths();
        System.out.println(dp.uniquePaths(51, 9));
    }
}
