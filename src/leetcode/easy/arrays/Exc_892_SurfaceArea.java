package leetcode.easy.arrays;

import leetcode.util.StringUtil;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_892_SurfaceArea
 * Author:   Xu Qinkun
 * Date:     2020/3/25 8:45
 * Description:
 */

public class Exc_892_SurfaceArea {

    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        int area = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                area += grid[i][j] * 6;
                area -= overlapArea(grid, i, j);
            }
        }
        return area;
    }

    private int overlapArea(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return 0;
        int overlap = (grid[i][j] - 1) * 2;
        if (i > 0) {
            int overlapI = Math.min(grid[i - 1][j], grid[i][j]) * 2;
            overlap += overlapI;
        }
        if (j > 0) {
            int overlapJ = Math.min(grid[i][j - 1], grid[i][j]) * 2;
            overlap += overlapJ;
        }
        return overlap;
    }

    public static void main(String[] args) {
        Exc_892_SurfaceArea sa = new Exc_892_SurfaceArea();
        int[][] a = StringUtil.stringToArray("[[2]]");
        System.out.println(sa.surfaceArea(a));
    }
}
