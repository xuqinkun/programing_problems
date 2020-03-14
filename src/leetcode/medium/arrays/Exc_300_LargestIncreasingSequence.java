package leetcode.medium.arrays;

public class Exc_300_LargestIncreasingSequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 0;
        if (n == 0) return max;
        int [] dp = new int[n];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Exc_300_LargestIncreasingSequence lis = new Exc_300_LargestIncreasingSequence();
        int[] a = {1,3,6,7,9,4,10,5,6};
        System.out.println(lis.lengthOfLIS(a));
    }
}
