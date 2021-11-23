package leetcode.medium.arrays;

public class Exc_931_MinFallingPathSum {


    public static void main(String[] args) {
        Exc_931_MinFallingPathSum mfp = new Exc_931_MinFallingPathSum();
        System.out.println(mfp.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]);
                } else {
                    matrix[i][j] += Math.min(Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]), matrix[i + 1][j + 1]);
                }

            }
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}
