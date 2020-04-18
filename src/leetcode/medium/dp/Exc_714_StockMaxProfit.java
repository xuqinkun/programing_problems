package leetcode.medium.dp;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_714_StockMaxProfit
 * Author:   Xu Qinkun
 * Date:     2020/4/18 10:00
 * Description:买卖股票的最佳时机含手续费
 */

public class Exc_714_StockMaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        Exc_714_StockMaxProfit sp = new Exc_714_StockMaxProfit();
        int[] p = {1, 3, 2, 8, 4, 9, 1, 3, 2, 8, 4, 9};
        System.out.println(sp.maxProfit(p, 2));
    }
}
