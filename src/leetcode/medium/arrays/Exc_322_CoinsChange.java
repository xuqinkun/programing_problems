package leetcode.medium.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_322_CoinsChange
 * Author:   Xu Qinkun
 * Date:     2020/3/17 11:33
 * Description: 零钱兑换
 */

public class Exc_322_CoinsChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        if (n == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Exc_322_CoinsChange cc = new Exc_322_CoinsChange();
        int[] coins = {1,2,3};
        int amount = 11;
        System.out.println(cc.coinChange(coins, amount));
    }
}
