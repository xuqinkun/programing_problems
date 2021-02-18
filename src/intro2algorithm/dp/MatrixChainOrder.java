package intro2algorithm.dp;

import java.util.Arrays;

public class MatrixChainOrder {

    public static int matrixChain(int[] p, int[][] s) {
        int n = p.length - 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int temp = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (dp[i][j] > temp) {
                        dp[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }
        return dp[1][n];
    }

    static void printOptimalPatterns(int[][] s, int i, int j) {
        if (i == j) {
            System.out.printf("A[%d]", i);
        } else {
            System.out.print("(");
            printOptimalPatterns(s, i, s[i][j]);
            printOptimalPatterns(s, s[i][j] + 1, j);
            System.out.print(")");
        }

    }


    public static void main(String[] args) {
//        int[] p = {5, 10, 3, 12, 5, 50, 6};
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] s = new int[p.length + 1][p.length + 1];
        System.out.println(matrixChain(p, s));
        printOptimalPatterns(s, 1, p.length - 1);
    }
}
