package leetcode.medium.arrays;

public class Exc_309_MaxProfit {

    public static void main(String[] args) {
        Exc_309_MaxProfit mp = new Exc_309_MaxProfit();
        System.out.println(mp.maxProfit(new int[]{2, 1})); // 3
        System.out.println(mp.maxProfit(new int[]{4,2,7,1,11})); // 3
        System.out.println(mp.maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
        System.out.println(mp.maxProfit(new int[]{1, 2, 6, 0, 2})); // 4
    }

    /**
     * f[i][0] 当前持有股票，累计获得的最大收益               -1  -1  -1  2
     * f[i][1] 当前不持有股票，处于冷冻期，累计获得的最大收益     0   0   1  2
     * f[i][2] 当前不持有股票，不处于冷冻期，累计获得的最大收益   0   1   2  2
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] f = new int[len][3];
        f[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[len - 1][2], f[len - 1][1]);
    }
}
