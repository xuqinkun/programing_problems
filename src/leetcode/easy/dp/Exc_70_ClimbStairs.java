package leetcode.easy.dp;

/**
 * Copyright (C), 2018-2020
 * FileName: ClimbStairs
 * Author:   Xu Qinkun
 * Date:     2020/3/18 11:02
 * Description:  爬楼梯
 */

public class Exc_70_ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        Exc_70_ClimbStairs cs = new Exc_70_ClimbStairs();
        System.out.println(cs.climbStairs(5));
    }
}
