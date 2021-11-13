package leetcode.medium.dp;

public class Exc_918_MaxSubarraySumCircular {
    public static void main(String[] args) {
        Exc_918_MaxSubarraySumCircular mssc = new Exc_918_MaxSubarraySumCircular();
        System.out.println(mssc.maxSubarraySumCircular(new int[]{-2,4,-5,4,-5,9,4}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{2,-2,2,7,8,0}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{-5}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{-5,3,5}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{1}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{5, 5}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(mssc.maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int max = Math.max(maxSubArraySum(nums, 0, len - 2, true),
                maxSubArraySum(nums, 1, len - 1, true));
        return Math.max(max, maxSubArraySum(nums, 0, len - 1, false));
    }

    private int maxSubArraySum(int[] nums, int l, int r, boolean cross) {
        if (l > r) return Integer.MIN_VALUE;
        if (l == r) return nums[l];
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int pos = 0, lPos = 0;
        for (int i = l; i <= r; i++) {
            int num = nums[i];
            if (sum + num < num) {
                sum = num;
                lPos = i;
            } else {
                sum += num;
            }
            if (maxSum <= sum) {
                maxSum = sum;
                pos = i;
            }
        }
        if (pos == nums.length - 1 && cross) {
            return maxSum + maxSubArraySum(nums, 0, lPos - 1, false);
        } else {
            return maxSum;
        }
    }
}
