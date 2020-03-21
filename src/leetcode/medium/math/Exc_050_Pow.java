package leetcode.medium.math;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_050_Pow
 * Author:   Xu Qinkun
 * Date:     2020/3/21 11:34
 * Description:
 */

public class Exc_050_Pow {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            return 1 / pow(x, -n);
        } else
            return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Exc_050_Pow pow = new Exc_050_Pow();
        System.out.println(pow.myPow(2, 10));
        System.out.println(pow.myPow(2.1, 3));
        System.out.println(pow.myPow(2, -2));
    }
}
