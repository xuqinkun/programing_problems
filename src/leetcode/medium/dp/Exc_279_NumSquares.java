package leetcode.medium.dp;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_279_NumSquars
 * Author:   Xu Qinkun
 * Date:     2020/3/20 10:55
 * Description:
 */

public class Exc_279_NumSquares {

    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);
        int[] arr = new int[max + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= max; i++) {
            arr[i] = i * i;
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = n + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Exc_279_NumSquares ns = new Exc_279_NumSquares();
        System.out.println(ns.numSquares(1));
    }
}
