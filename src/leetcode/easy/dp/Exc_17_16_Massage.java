package leetcode.easy.dp;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_17_16_Massage
 * Author:   Xu Qinkun
 * Date:     2020/3/24 10:38
 * Description:
 */

public class Exc_17_16_Massage {

    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[j - 1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Exc_17_16_Massage mass = new Exc_17_16_Massage();
        int[] a = {1,2,8};
        System.out.println(mass.massage(a));
    }
}
