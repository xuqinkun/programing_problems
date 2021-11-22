package leetcode.medium.arrays;

public class Exc_1314_MatrixBlockSum {

    private static void print(int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.printf("%d ", ans[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Exc_1314_MatrixBlockSum mb = new Exc_1314_MatrixBlockSum();
        print(mb.matrixBlockSum(mat, 1));
        print(mb.matrixBlockSum(mat, 2));
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int topMost = Math.max(0, i - k);
                int downMost = Math.min(m - 1, i + k);
                int leftMost = Math.max(0, j - k);
                int rightMost = Math.min(n - 1, j + k);
                for (int l = topMost; l <= downMost; l++) {
                    for (int o = leftMost; o <= rightMost; o++) {
                        ans[i][j] += mat[l][o];
                    }
                }
            }
        }
        return ans;
    }
}
