package leetcode.medium.dp;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_198_Rob
 * Author:   Xu Qinkun
 * Date:     2020/4/1 11:25
 * Description: 打家劫舍
 */

public class Exc_213_Rob2 {

    public static void main(String[] args) {
        Exc_213_Rob2 rob = new Exc_213_Rob2();
//        System.out.println(rob.rob(new int[]{2, 3, 2}));
//        System.out.println(rob.rob(new int[]{2, 3}));
//        System.out.println(rob.rob(new int[]{2}));
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(0, n - 2, nums), robRange(1, n - 1, nums));
    }

    private int robRange(int start, int end, int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
