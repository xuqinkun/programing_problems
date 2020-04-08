package leetcode.medium.dfs;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_13_MovingCount
 * Author:   Xu Qinkun
 * Date:     2020/4/8 9:39
 * Description: 机器人的运动范围
 */

public class Exc_13_MovingCount {
    private int[] offsetX = {-1, 0, 1, 0};
    private int[] offsetY = {0, -1, 0, 1};

    public int movingCount(int m, int n, int k) {
        boolean[][] marks = new boolean[m][n];
        return dfs(m, n, 0, 0, k, marks);
    }

    private int dfs(int m, int n, int x, int y, int k, boolean[][] marks) {
        if (marks[y][x]) return 0;
        marks[y][x] = true;
        if (y == m - 1 && x == n - 1) return 1;
        int count = 0;
        for (int i = 0; i < offsetX.length; i++) {
            int tmpX = x + offsetX[i];
            int tmpY = y + offsetY[i];
            if (inArea(m, n, tmpX, tmpY) && !marks[tmpY][tmpX] && entryPermit(tmpX, tmpY, k)) {
                marks[y][x] = true;
                count += dfs(m, n, tmpX, tmpY, k, marks);
            }
        }
        return count + 1;
    }

    private boolean entryPermit(int x, int y, int k) {
        int sums = sumOfNumBits(x) + sumOfNumBits(y);
        return sums <= k;
    }

    private int sumOfNumBits(int x) {
        int sum = 0;
        while (x != 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }


    private boolean inArea(int m, int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) {
        Exc_13_MovingCount mc = new Exc_13_MovingCount();
        System.out.println(mc.movingCount(3, 1, 0));
    }
}
