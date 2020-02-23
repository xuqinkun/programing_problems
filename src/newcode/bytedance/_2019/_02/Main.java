package newcode.bytedance._2019._02;

import java.util.Scanner;

public class Main {

    public static final int BASE = 99997867;

    public int solution(int n, int d, int[] pos) {
        int count = 0;
        for (int i = 0; i + 2 < n; i++) {
            int startPos = pos[i];
            int maxPos = Math.min(startPos + d, pos[n - 1]); // 离起点最远的坐标
            int startIndex = i, endIndex = startIndex + 2;

            while (endIndex < n && pos[endIndex] <= maxPos) {
                int tmp = (endIndex - startIndex - 1) % BASE;
                count = (count + tmp) % 99997867;
                endIndex ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(n, d, pos));
        sc.close();
    }
}
