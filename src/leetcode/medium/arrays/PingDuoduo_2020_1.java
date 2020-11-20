package leetcode.medium.arrays;

import java.util.Arrays;

public class PingDuoduo_2020_1 {

    public static int maxProfit(int[][] data, int count, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < count; i++) {
            int weight = data[i][0];
            int value = data[i][1];
            for (int j = capacity; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }
        return dp[capacity];
    }

    public static int dp(int[] weights, int[] values, int cap)
    {
        System.out.print("[");
        for (int i = 0; i < cap; i++) {
            System.out.printf("%d, ", i);
        }
        System.out.print("]\n");
        int[] dp = new int[cap+1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = cap; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[cap];
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt(), M = sc.nextInt();
//        int[][] weightValues = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            weightValues[i][0] = sc.nextInt();
//            weightValues[i][1] = sc.nextInt();
//        }
//        sc.close();
//        System.out.println(maxProfit(weightValues, N, M));
        int[] weights = {3, 4, 2, 2, 7, 5, 6};
        int[] values = {2,3,3,1,6,3,5};
        System.out.println(dp(weights,values, 14));;
    }
}
