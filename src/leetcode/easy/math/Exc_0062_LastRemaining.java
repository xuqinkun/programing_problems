package leetcode.easy.math;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_0062_LastRemaining
 * Author:   Xu Qinkun
 * Date:     2020/3/30 10:02
 * Description: 圆圈中最后剩下的数字
 */

public class Exc_0062_LastRemaining {

    public int lastRemaining(int n, int m) {
        int i = 1, last = 0;
        while (i < n) {
            last = (last + m) % (i + 1);
            i++;
        }
        return last;
    }

    public static void main(String[] args) {
        Exc_0062_LastRemaining lr = new Exc_0062_LastRemaining();
        System.out.println(lr.lastRemaining(1, 17));
    }
}
