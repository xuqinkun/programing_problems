package leetcode.medium.arrays;

public class Exc_304_NumMatrix {
    private int[][] preMat;

    public Exc_304_NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        preMat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                preMat[i][j] += matrix[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Exc_304_NumMatrix nm = new Exc_304_NumMatrix(new int[][]{{-1}});
        System.out.println(nm.sumRegion(0, 0, 0, 0));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 >= 1 && col1 >= 1)
            return preMat[row2][col2] - preMat[row1 - 1][col2] - preMat[row2][col1 - 1] + preMat[row1 - 1][col1 - 1];
        else if (row1 == 0 && col1 >= 1)
            return preMat[row2][col2] - preMat[row2][col1 - 1];
        else if (row1 >= 1 && col1 == 0)
            return preMat[row2][col2] - preMat[row1 - 1][col2];
        else
            return preMat[row2][col2];
    }

}
