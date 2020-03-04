package leetcode.medium.arrays;

public class Exc_059_SpinArrays {
    public int[][] generateMatrix(int n) {
        int step, i, j, counter = 1, total = n * n;
        int ans[][] = new int[n][n];

        for (step = 0; step <= (n - 1) / 2; step++) {
            i = step;
            for (j = step; j < n - step; j++) {
                if (counter > total) break;
                ans[i][j] = counter++;
            }
            j--;
            for (i = step + 1; i < n - step; i++) {
                if (counter > total) break;
                ans[i][j] = counter++;
            }
            i--;
            for (j = n - step - 2; j >= step; j--) {
                if (counter > total) break;
                ans[i][j] = counter++;
            }
            j++;
            for (i = n - step - 2; i > step; i--) {
                if (counter > total) break;
                ans[i][j] = counter++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_059_SpinArrays sa = new Exc_059_SpinArrays();
        int n = 7;
        int[][] ans = sa.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", ans[i][j]);
            }
            System.out.println();
        }

    }
}
