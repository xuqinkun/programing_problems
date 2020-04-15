package leetcode.medium.arrays;

import leetcode.util.StringUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_542_DistanceOfMatrix
 * Author:   Xu Qinkun
 * Date:     2020/4/15 9:02
 * Description: 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 */

public class Exc_542_DistanceOfMatrix {

    private int[] offsetI = {-1, 0, 1, 0};
    private int[] offsetJ = {0, -1, 0, 1};

    class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] mark = new boolean[rowSize][colSize];
        int[][] dis = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Pos(i, j));
                    mark[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            Pos p = queue.remove();
            int i = p.i, j = p.j;
            for (int k = 0; k < offsetI.length; k++) {
                int tmpI = offsetI[k] + i;
                int tmpJ = offsetJ[k] + j;
                if (inArea(tmpI, rowSize) && inArea(tmpJ, colSize) && !mark[tmpI][tmpJ]) {
                    mark[tmpI][tmpJ] = true;
                    dis[tmpI][tmpJ] = dis[i][j] + 1;
                    queue.add(new Pos(tmpI, tmpJ));
                }
            }
        }
        return dis;
    }

    private boolean inArea(int i, int rage) {
        return i >= 0 && i < rage;
    }

    public static void main(String[] args) {
        Exc_542_DistanceOfMatrix dm = new Exc_542_DistanceOfMatrix();
        int[][] a = StringUtil.stringToArray("[[1,0,1],[1,1,1],[1,0,1]]");
        int[][] b = dm.updateMatrix(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }
}
