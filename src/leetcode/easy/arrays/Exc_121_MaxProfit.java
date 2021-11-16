package leetcode.easy.arrays;

public class Exc_121_MaxProfit {

    public static void main(String[] args) {
        Exc_121_MaxProfit mp = new Exc_121_MaxProfit();
        System.out.println(mp.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(mp.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(mp.maxProfit(new int[]{7, 6, 7}));
        System.out.println(mp.maxProfit(new int[]{7, 6}));
        System.out.println(mp.maxProfit(new int[]{0, 12}));
        System.out.println(mp.maxProfit(new int[]{1,2,3,4,5}));
    }

    public int maxProfit(int[] prices) {
        int totalProfit = 0, minPrice = prices[0], maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            if (curr < minPrice) {
                minPrice = curr;
                maxPrice = curr;
            } else if (curr > maxPrice) {
                maxPrice = curr;
            }
            totalProfit += Math.max(0, maxPrice - minPrice);
            minPrice = maxPrice;
        }
        return totalProfit;
    }
}
