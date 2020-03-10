package leetcode.medium.arrays;

import java.util.HashSet;
import java.util.Set;

public class Exc_073_SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;
        if (col == 0) return;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i: rowSet) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i: colSet) {
            for (int j = 0; j < row; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
