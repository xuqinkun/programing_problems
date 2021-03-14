package leetcode.easy.arrays;

import java.util.Arrays;

public class Exc_336_Transpose {

    public int[][] transpose(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int[][] ret = new int[colSize][rowSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }

    public void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]));
            System.out.print(',');
        }
    }

    public static void main(String[] args) {
        Exc_336_Transpose trans = new Exc_336_Transpose();
        trans.printArray(trans.transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        trans.printArray(trans.transpose(new int[][]{{1,2,3},{4,5,6}}));
    }
}
