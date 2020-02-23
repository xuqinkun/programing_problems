package newcode.meituan._2019._05;
/**
 * 小明同学在参加一场考试，考试时间2个小时。试卷上一共有n道题目，小明要在规定时间内，完成一定数量的题目。
 * 考试中不限制试题作答顺序，对于 i 第道题目，小明有三种不同的策略可以选择:  (1)直接跳过这道题目，不花费时间，本题得0分。
 *
 * (2)只做一部分题目，花费pi分钟的时间，本题可以得到ai分。  (3)做完整个题目，花费qi分钟的时间，本题可以得到bi分。
 *
 * 小明想知道，他最多能得到多少分。
 */

import java.util.Scanner;

public class Main {

    public int bag(int [] w1, int [] w2, int [] v1, int [] v2, int n, int time) {
        int max = 0;
        int [] d = new int[time + 1];
        for (int i = 0; i < n; i++) {
            for (int j = time; j > 0; j--) {
                if (j >= w2[i]) {
//                    int temp = Math.max(d[j - w1[i]] + v1[i], d[j - w2[i]] + v2[i]);
                    d[j] = Math.max(d[j], d[j - w2[i]] + v2[i]);
                }
                else if (j >= w1[i] && j < w2[i]) {
                    d[j] = Math.max(d[j], d[j - w1[i]] + v1[i]);
                }
                max = Math.max(d[j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w1 = new int[n];
        int[] w2 = new int[n];
        int[] v1 = new int[n];
        int[] v2 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = sc.nextInt();
            v1[i] = sc.nextInt();
            w2[i] = sc.nextInt();
            v2[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(new Main().bag(w1, w2, v1, v2, n, 120));
    }
}
