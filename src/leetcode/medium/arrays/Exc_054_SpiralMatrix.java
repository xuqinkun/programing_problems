package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

public class Exc_054_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] a) {
        if (a.length == 0 || a[0].length == 0) return new ArrayList<>();
        int row = a.length, col = a[0].length;
        int min = Math.min(row / 2, col / 2);
        int i, j, endX = (col + 1) / 2, endY = (row + 1) / 2;
        ArrayList<Integer> list = new ArrayList<>();
        for (int startX = 0, startY = 0; startX < endX && startY < endY; startX++, startY++) {
            i = startY;
            for (j = startX; j < col - startX; j++) {
                list.add(a[i][j]);
            }
            j--;
            if (startX + 1 == row - startX) {
                break;
            }
            for (i = startY + 1; i < row - startY; i++) {
                list.add(a[i][j]);
            }
            i--;
            if (col - 2 - startX < startX) break;
            for (j = col - 2 - startX; j >= startX; j--) {
                list.add(a[i][j]);
            }
            j++;
            for (i = row - 2 - startY; i > startY; i--) {
                list.add(a[i][j]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Exc_054_SpiralMatrix sm = new Exc_054_SpiralMatrix();
        int[][] a = {
                {1},
                {4},
                {7},
        };
        System.out.println(sm.spiralOrder(a));
    }
}
