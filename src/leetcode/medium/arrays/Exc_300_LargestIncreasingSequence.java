package leetcode.medium.arrays;

public class Exc_300_LargestIncreasingSequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 0;
        if (n == 0) return max;
        int [] dp = new int[n + 1];
        dp[1] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (dp[len] < nums[i]) dp[++len] = nums[i];
            else {
                int l = 1, r = len, mid = 0, pos = 0;
                while (l <= r) {
                    mid = (l + r) >> 1;
                    if (dp[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Exc_300_LargestIncreasingSequence lis = new Exc_300_LargestIncreasingSequence();
        int[] a = {1,3,6,7,9,4,5,6};
        System.out.println(lis.lengthOfLIS(a));
    }
}
