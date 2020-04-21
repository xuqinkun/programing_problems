package leetcode.medium.arrays;

import java.util.*;

/**
 * Copyright (C), 2018-2020
 * FileName: Solution
 * Author:   Xu Qinkun
 * Date:     2020/4/18 15:21
 * Description:
 */

public class Solution {
    public int minCount(int[] coins) {
        int times = 0;
        for (int i = 0; i < coins.length; i++) {
            times += (coins[i] + 1) / 2;
        }
        return times;
    }

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = relation.length;
        for (int i = 0; i < len; i++) {
            int from = relation[i][0];
            int to = relation[i][1];
            if (!graph.containsKey(from)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(to);
                graph.put(from, list);
            } else {
                graph.get(from).add(to);
            }
        }
        int[][] dp = new int[6][10];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] != 0 && graph.containsKey(j)) {
                    for (int x : graph.get(j)) {
                        dp[i][x] += dp[i - 1][j];
                    }
                }
            }
        }
        return dp[k][n - 1];
    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int c = 0, r = 0, h = 0;
        int n = requirements.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < increase.length; i++) {
            c += increase[i][0];
            r += increase[i][1];
            h += increase[i][2];
            for (int j = 0; j < n; j++) {
                if (0 == requirements[j][0] && 0 == requirements[j][1] && 0 == requirements[j][2] && ans[j] == -1) {
                    ans[j] = 0;
                } else if (c >= requirements[j][0] && r >= requirements[j][1] && h >= requirements[j][2] && ans[j] == -1) {
                    ans[j] = i + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.minCount(new int[]{2, 3, 10}));
//        System.out.println(sol.numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
//        System.out.println(sol.numWays(3, new int[][]{{0, 2}, {2, 1}, {1, 2}}, 3));
        int[] triggerTime = sol.getTriggerTime(new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}}, new int[][]{{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}});
        System.out.println(Arrays.toString(triggerTime));
    }
}
