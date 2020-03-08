package leetcode.medium.arrays;

public class Exc_048_RotateMatrix {

    private void swap(int[][] a, int row1, int col1, int row2, int col2) {
        int temp = a[row1][col1];
        a[row1][col1] = a[row2][col2];
        a[row2][col2] = temp;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 转置
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // 交换列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Exc_048_RotateMatrix rm = new Exc_048_RotateMatrix();

    }
}
