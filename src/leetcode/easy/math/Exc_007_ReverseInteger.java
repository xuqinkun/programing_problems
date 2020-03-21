package leetcode.easy.math;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_007_ReverseInteger
 * Author:   Xu Qinkun
 * Date:     2020/3/21 11:56
 * Description:
 */

public class Exc_007_ReverseInteger {
    public int reverse(int x) {
        long ans = 0, tmp = x;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            tmp = -tmp;
        }
        while (tmp != 0) {
            ans = ans * 10 + tmp % 10;
            tmp /= 10;
        }
        if (!negative && ans > Integer.MAX_VALUE) return 0;
        if (negative && ans > (long)Integer.MAX_VALUE + 1) return 0;
        return (int) (negative ? -ans : ans);
    }

    public static void main(String[] args) {
        Exc_007_ReverseInteger ri = new Exc_007_ReverseInteger();
//        System.out.println(ri.reverse(1));
//        System.out.println(ri.reverse(Integer.MAX_VALUE - 5));
//        System.out.println(ri.reverse(Integer.MIN_VALUE + 6));
        System.out.println(ri.reverse(-123456789));
        System.out.println(ri.reverse(120));
    }
}
