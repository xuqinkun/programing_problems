package leetcode.medium.bfs;

import leetcode.util.StringUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1162_MapAnalyse
 * Author:   Xu Qinkun
 * Date:     2020/3/29 9:42
 * Description:
 */

public class Exc_1162_MapAnalyse {

    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(i * n + j);
                }
            }
        }
        int size = queue.size();
        if (size == 0 || size == n * n)
            return -1;

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                int head = queue.poll();
                int x = head % n, y = head / n;
                for (int k = 0; k < dx.length; k++) {
                    int ti = y + dy[k];
                    int tj = x + dx[k];
                    if (ti >= 0 && ti < n && tj >= 0 && tj < n && grid[ti][tj] == 0) {
                        queue.add(ti * n + tj);
                        grid[ti][tj] = 1;
                    }
                }
            }
            max++;
        }
        return max - 1;
    }

    public static void main(String[] args) {
        Exc_1162_MapAnalyse ma = new Exc_1162_MapAnalyse();
        int[][] g = StringUtil.stringToArray("[[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]");
        System.out.println(ma.maxDistance(g));
    }
}
