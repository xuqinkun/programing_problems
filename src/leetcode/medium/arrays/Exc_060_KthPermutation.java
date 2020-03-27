package leetcode.medium.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_060_KthPermutation
 * Author:   Xu Qinkun
 * Date:     2020/3/27 9:17
 * Description:第k个排列
 */

public class Exc_060_KthPermutation {

    public String getPermutation(int n, int k) {
        char[] perm = new char[n];
        for (int i = 0; i < n; i++) {
            perm[i] = (char) ('1' + i);
        }
        int[] factorials = factorial(n - 1);
        int i = 0;
        while (i < n - 1) {
            int t = factorials[n - i - 2];
            int j = k < t ? 0 : (k - 1) / t;
            insertInto(perm, i, i + j);
            k = k < t ? k : ((k - 1) % t + 1);
            i++;
        }
        return new String(perm);
    }

    private void insertInto(char[] perm, int i, int j) {
        char c = perm[j];
        System.arraycopy(perm, i, perm, i + 1, j - i);
        perm[i] = c;
    }

    private int[] factorial(int n) {
        int[] factorials = new int[n];
        int f = 1;
        for (int i = 0; i < n; i++) {
            f = f * (i + 1);
            factorials[i] = f;
        }
        return factorials;
    }

    public static void main(String[] args) {
        Exc_060_KthPermutation kp = new Exc_060_KthPermutation();
        int n = 4, fact = 24;
        for (int i = 1; i <= fact; i++) {
            System.out.println(kp.getPermutation(n, i));
        }
    }
}
