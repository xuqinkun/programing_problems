package leetcode.medium.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_01_07_RotateMatrix
 * Author:   Xu Qinkun
 * Date:     2020/4/7 16:03
 * Description:
 */

public class Exc_01_07_RotateMatrix {

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;
        if (col == 0) return;
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                swap(matrix, i, j, row - i - 1, j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tmp;
    }

    public static void main(String[] args) {
        Exc_01_07_RotateMatrix rm = new Exc_01_07_RotateMatrix();
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rm.rotate(a);
        for (int[] t: a) {
            System.out.println(Arrays.toString(t));
        }
    }
}
