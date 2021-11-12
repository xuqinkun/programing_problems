package leetcode.medium.dp;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_198_Rob
 * Author:   Xu Qinkun
 * Date:     2020/4/1 11:25
 * Description: 打家劫舍
 */

public class Exc_198_Rob {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 0) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Exc_198_Rob rob = new Exc_198_Rob();
        int[] a = {2,7,9,3,1};
        System.out.println(rob.rob(a));
    }
}
