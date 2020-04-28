package leetcode.medium.bfs;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_200_NumIslands
 * Author:   Xu Qinkun
 * Date:     2020/4/28 9:23
 * Description: 岛屿数量
 */

public class Exc_200_NumIslands {
    private int[] offsetI = {-1, 0, 1, 0};
    private int[] offsetJ = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int rowSize = grid.length;
        if (rowSize == 0) return 0;
        int colSize = grid[0].length;
        if (colSize == 0) return 0;
        int ans = 0;
        boolean[][] mark = new boolean[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!mark[i][j] && dfs(grid, rowSize, colSize, i, j, mark) > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int dfs(char[][] grid, int rowSize, int colSize, int i, int j, boolean[][] mark) {
        if (grid[i][j] == '0') return 0;
        mark[i][j] = true;
        int count = 1;
        for (int k = 0; k < offsetI.length; k++) {
            int tempI = i + offsetI[k];
            int tempJ = j + offsetJ[k];
            if (inArea(tempI, tempJ, rowSize, colSize) && !mark[tempI][tempJ] && grid[tempI][tempJ] == '1') {
                mark[tempI][tempJ] = true;
                count += dfs(grid, rowSize, colSize, tempI, tempJ, mark);
            }
        }
        return count;
    }

    private boolean inArea(int i, int j, int rowSize, int colSize) {
        return i >= 0 && i < rowSize && j >= 0 && j < colSize;
    }

    public static void main(String[] args) {
        Exc_200_NumIslands ni = new Exc_200_NumIslands();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'},};
//        char[][] grid={{'1','1','1'},{'0','1','0'},{'0','1','0'},};
        System.out.println(ni.numIslands(grid));
    }
}
