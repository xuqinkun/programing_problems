package leetcode.easy.arrays;

public class Exc_766_ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int startJ = 0; startJ < col; startJ++) {
            int flag = matrix[0][startJ];
            for (int i = 1, j = startJ + 1; i < row && j < col; i++, j++) {
                if (flag != matrix[i][j]) {
                    return false;
                }
            }
        }
        for (int startI = 1; startI < row; startI++) {
            int flag = matrix[startI][0];
            for (int i = startI + 1, j = 1; i < row && j < col; i++, j++) {
                if (flag != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Exc_766_ToeplitzMatrix tm = new Exc_766_ToeplitzMatrix();
        System.out.println(tm.isToeplitzMatrix2(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println(tm.isToeplitzMatrix2(new int[][]{{1, 2}, {2, 2}}));
        System.out.println(tm.isToeplitzMatrix2(new int[][]{{1, 2}}));
    }
}
