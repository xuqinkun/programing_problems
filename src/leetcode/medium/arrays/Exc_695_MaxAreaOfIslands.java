package leetcode.medium.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_695_MaxAreaOfIslands
 * Author:   Xu Qinkun
 * Date:     2020/3/16 12:03
 * Description:岛屿的最大面积
 */

public class Exc_695_MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int rowSize = grid.length;
        if (rowSize == 0) return 0;
        int colSize = grid[0].length;
        if (colSize == 0) return 0;
        int[] dp = new int[colSize];

        boolean[][] marks = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] != 0 && !marks[i][j])
                    dp[j] = Math.max(dp[j], dfs(grid, i, j, marks));
            }
        }
        int max = 0;
        for (int i = 0; i < colSize; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] marks) {
        int rowSize = grid.length, colSize = grid[0].length;
        if (i < 0 || j < 0 || i >= rowSize || j >= colSize) return 0;
        if (grid[i][j] == 0 || marks[i][j]) return 0;
        marks[i][j] = true;
        int up = dfs(grid, i - 1, j, marks);
        int down = dfs(grid, i + 1, j, marks);
        int left = dfs(grid, i, j - 1, marks);
        int right = dfs(grid, i, j + 1, marks);
        return 1 + up + down + left + right;
    }

    public static void main(String[] args) {
        Exc_695_MaxAreaOfIslands ma = new Exc_695_MaxAreaOfIslands();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}
                ;
        System.out.println(ma.maxAreaOfIsland(grid));
    }
}
