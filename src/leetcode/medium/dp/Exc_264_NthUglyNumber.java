package leetcode.medium.dp;

public class Exc_264_NthUglyNumber {

    public static void main(String[] args) {
        Exc_264_NthUglyNumber nn = new Exc_264_NthUglyNumber();
        System.out.println(nn.nthUglyNumber(1));
        System.out.println(nn.nthUglyNumber(10));
    }

    /**
     * f[i] represents the nth ugly number
     * f[1] = 1
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[i] == dp[p2] * 2)
                p2++;
            else if (dp[i] == dp[p3] * 3)
                p3++;
            else
                p5++;
            if (dp[i] == dp[i-1])
                i--;
        }
        return dp[n - 1];
    }
}
