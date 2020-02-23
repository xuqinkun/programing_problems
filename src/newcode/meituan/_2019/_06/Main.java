package newcode.meituan._2019._06;
/**
 * 一条直线上等距离放置了n台路由器。路由器自左向右从1到n编号。第i台路由器到第j台路由器的距离为| i-j |。
 * 每台路由器都有自己的信号强度，第i台路由器的信号强度为ai。
 * 所有与第i台路由器距离不超过ai的路由器可以收到第i台路由器的信号（注意，每台路由器都能收到自己的信号）。
 * 问一共有多少台路由器可以收到至少k台不同路由器的信号。
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*public int signal(int n, int k, int[] a) {
        int [] b = new int[n];
        int count = 0;
        Arrays.fill(b, 1);
        for (int i = 0; i < n; i++) {
            int start = Math.max(i - a[i], 0);
            int end = Math.min(i + a[i], n - 1);
            for (int j = start; j <= end; j++) {
                if (j != i)
                    b[j]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (b[i] >= k)
                count++;
        }
        return count;
    }
    */
    public int signal(int n, int k, int[] a) {
        int[][] pos = new int[n][2];
        int[] dp = new int[n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            pos[i][0] = Math.max(i - a[i], 0);
            pos[i][1] = Math.min(i + a[i] + 1, n);
        }
        for (int i = 0; i < n; i++) {
            dp[pos[i][0]] += 1;
            dp[pos[i][1]] -= 1;
        }
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += dp[i];
            if (tmp >= k)
                count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(new Main().signal(n, k, a));
    }
}
