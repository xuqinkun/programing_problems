package leetcode.easy.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_53_MaxSubArray
 * Author:   Xu Qinkun
 * Date:     2020/3/18 10:45
 * Description: 最大子序和
 */

public class Exc_53_MaxSubArray {

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int m = (left + right) / 2;
        int leftSum = helper(nums, left, m);
        int rightSum = helper(nums, m + 1, right);
        int crossSum = crossSum(nums, left, right, m);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int crossSum(int[] nums, int left, int right, int m) {
        if (left > right) return 0;
        if (left == right) return nums[left];

        int sum = 0, leftSum = Integer.MIN_VALUE;
        for (int i = m; i >= left ; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        Exc_53_MaxSubArray ms = new Exc_53_MaxSubArray();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(ms.maxSubArray(a));
    }
}
