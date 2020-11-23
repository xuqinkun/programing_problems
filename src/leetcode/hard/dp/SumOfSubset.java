package leetcode.hard.dp;

public class SumOfSubset {

    public static boolean sumOfSubset(int[] arr, int k) {
        int[] dp = new int[k + 1];
        for (int v : arr) {
            for (int i = k; i >= v; i--) {
                if (dp[i] != i)
                    dp[i] = dp[i - v] + v;
            }
        }
        return dp[k] == k;
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 5, 6, 7};
        for (int i = 0; i < 22; i++) {
            System.out.println((i + 1) + ": " + sumOfSubset(set, i + 1));
        }
    }
}
