package leetcode.medium.dp;

public class Exc_740_DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int val : nums) {
            max = Math.max(val, max);
        }
        int[] sums = new int[max + 1];
        for (int val : nums) {
            sums[val] += val;
        }
        return rob(sums);
    }

    private int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Exc_740_DeleteAndEarn de = new Exc_740_DeleteAndEarn();
        System.out.println(de.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(de.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(de.deleteAndEarn(new int[]{3,4,2,2,2,4,1,6}));
    }
}
