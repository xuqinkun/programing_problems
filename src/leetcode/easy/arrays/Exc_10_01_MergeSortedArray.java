package leetcode.easy.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_10_01_MergeSortedArray
 * Author:   Xu Qinkun
 * Date:     2020/3/17 10:06
 * Description:给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 */

public class Exc_10_01_MergeSortedArray {

    public void merge(int[] A, int m, int[] B, int n) {
        if (m == 0) {
            System.arraycopy(B,0, A, 0, n);
            return;
        }
        if (n == 0) return;
        int i = m - 1, j = n - 1, idx = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[idx--] = A[i--];
            } else {
                A[idx--] = B[j--];
            }
        }
        while (i >= 0) {
            A[idx--] = A[i--];
        }
        while (j >= 0) {
            A[idx--] = B[j--];
        }
    }

    public static void main(String[] args) {
        Exc_10_01_MergeSortedArray ms = new Exc_10_01_MergeSortedArray();
        int[] a = {0,1,2,8};
        int[] b = {0,2};
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];
        System.arraycopy(a, 0, c, 0, m);
        ms.merge(c, m, b, n);
        System.out.println(Arrays.toString(c));
    }
}
