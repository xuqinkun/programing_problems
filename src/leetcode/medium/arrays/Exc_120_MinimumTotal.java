package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

public class Exc_120_MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int rowSize = triangle.size();
        int[] dp = new int[rowSize];
        int prev = 0, cur;
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < rowSize; i++) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                cur = dp[j];
                if (j == 0) {
                    dp[j] = cur + rows.get(j);
                } else if (j == i) {
                    dp[j] = prev + rows.get(j);
                } else {
                    dp[j] = rows.get(j) + Math.min(cur, prev);
                }
                prev = cur;
            }
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Exc_120_MinimumTotal mt = new Exc_120_MinimumTotal();
        int[][] a = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] row : a) {
            List<Integer> list = new ArrayList<>();
            for (int val :
                    row) {
                list.add(val);
            }
            triangle.add(list);
        }
        System.out.println(mt.minimumTotal(triangle));
    }
}
