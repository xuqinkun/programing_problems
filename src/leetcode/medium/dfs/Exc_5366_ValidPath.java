package leetcode.medium.dfs;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_5366_ValidPath
 * Author:   Xu Qinkun
 * Date:     2020/3/22 11:03
 * Description: 检查网格中是否存在有效路径
 * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 *
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3 表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 */

public class Exc_5366_ValidPath {

    public boolean hasValidPath(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] mark = new boolean[row][col];
        return dfs(grid, 0, 0, row, col, mark);
    }

    private boolean dfs(int[][] grid, int i, int j, int row, int col, boolean[][] mark) {
        if (i == (row - 1) && j == (col - 1)) return true;
        if (i < 0 || i >= row || j < 0 || j >= col) return false;
        if (mark[i][j]) return false;
        int tag = grid[i][j];
        mark[i][j] = true;
        if (tag == 1) {
            if (turnRight(grid, i, j, row, col, mark)) return true;
            if (turnLeft(grid, i, j, row, col, mark)) return true;
        }
        else if (tag == 2) {
            if (turnUp(grid, i, j, row, col, mark)) return true;
            if (turnDown(grid, i, j, row, col, mark)) return true;
        }
        else if (tag == 3) {
            if (turnDown(grid, i, j, row, col, mark)) return true;
            if (turnLeft(grid, i, j, row, col, mark)) return true;
        }
        else if (tag == 4) {
            if (turnDown(grid, i, j, row, col, mark)) return true;
            if (turnRight(grid, i, j, row, col, mark)) return true;
        }
        else if (tag == 5) {
            if (turnUp(grid, i, j, row, col, mark)) return true;
            if (turnLeft(grid, i, j, row, col, mark)) return true;
        }
        else if (tag == 6) {
            if (turnUp(grid, i, j, row, col, mark)) return true;
            if (turnRight(grid, i, j, row, col, mark)) return true;
        }
        mark[i][j] = false;
        return false;
    }

    private boolean turnUp(int[][] grid, int i, int j, int row, int col, boolean[][] mark) {
        return i - 1 >= 0 && !mark[i - 1][j] &&
                (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4) &&
                dfs(grid, i - 1, j, row, col, mark);
    }

    private boolean turnDown(int[][] grid, int i, int j, int row, int col, boolean[][] mark) {
        return i + 1 < row && !mark[i + 1][j] &&
                (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6) &&
                dfs(grid, i + 1, j, row, col, mark);
    }

    private boolean turnLeft(int[][] grid, int i, int j, int row, int col, boolean[][] mark) {
        return j - 1 >= 0 && !mark[i][j - 1] &&
                (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j + 1] == 6) &&
                dfs(grid, i, j - 1, row, col, mark);
    }

    private boolean turnRight(int[][] grid, int i, int j, int row, int col, boolean[][] mark) {
        return j + 1 < col && !mark[i][j + 1] &&
                (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5) &&
                dfs(grid, i, j + 1, row, col, mark);
    }

    public static void main(String[] args) {
        Exc_5366_ValidPath vp = new Exc_5366_ValidPath();
        int[][] grid = {{1,1,2}};
        System.out.println(vp.hasValidPath(grid));
    }
}
