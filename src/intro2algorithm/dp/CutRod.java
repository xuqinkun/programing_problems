package intro2algorithm.dp;

import java.util.Arrays;

public class CutRod {

    public static int cutRod(int[] price, int n) {
        if (n == 0) return 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            p = Math.max(p, price[i] + cutRod(price, n - i));
        }
        return p;
    }

    public static int bottomUpCutRod(int[] price, int[] s, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int p = 0;
            for (int j = 1; j <= i; j++) {
                int temp = price[j - 1] + dp[i - j];
                if (p < temp) {
                    p = temp;
                    s[i - 1] = j;
                }
            }
            dp[i] = p;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] s = new int[price.length];
        System.out.println(bottomUpCutRod(price, s, 9));
        System.out.println(Arrays.toString(s));
    }
}
