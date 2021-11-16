package leetcode.medium.arrays;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 */
public class Exc_714_MaxProfit {

    public static void main(String[] args) {
        Exc_714_MaxProfit mp = new Exc_714_MaxProfit();
        System.out.println(mp.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(mp.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    /**
     * dp[i][0] 持有股票
     * dp[i][1] 不持有股票
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[len - 1][1];
    }
}
