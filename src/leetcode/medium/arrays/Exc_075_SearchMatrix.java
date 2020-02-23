package leetcode.medium.arrays;

public class Exc_075_SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            }
            else if (target > matrix[i][j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exc_075_SearchMatrix sm = new Exc_075_SearchMatrix();
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(sm.searchMatrix(new int[][]{}, 13));
    }
}
