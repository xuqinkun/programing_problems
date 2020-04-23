package leetcode.medium.dp;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_08_11_CoinsDivision
 * Author:   Xu Qinkun
 * Date:     2020/4/23 10:03
 * Description:
 */

public class Exc_08_11_CoinsDivision {
    int[] coins = new int[]{1, 5, 10, 25};

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length && coins[i] <= n; i++) {
            int val = coins[i];
            for (int j = val; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - val]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Exc_08_11_CoinsDivision cd = new Exc_08_11_CoinsDivision();
        System.out.println(cd.waysToChange(9));
    }
}
