package leetcode.easy.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_121_SailStocks
 * Author:   Xu Qinkun
 * Date:     2020/3/16 9:23
 * Description:买卖股票的最佳时机
 */

public class Exc_121_SailStocks {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int maxProfit = 0, tmp = 0, sum = 0;

        for (int i = 0; i < n - 1; i++) {
            tmp = prices[i + 1] - prices[i];
            if (sum + tmp < tmp) {
                sum = tmp;
            } else {
                sum += tmp;
            }
            maxProfit = Math.max(sum, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Exc_121_SailStocks ss = new Exc_121_SailStocks();
        int[] a = {7,6,4,3,4};
        System.out.println(ss.maxProfit(a));
    }
}
