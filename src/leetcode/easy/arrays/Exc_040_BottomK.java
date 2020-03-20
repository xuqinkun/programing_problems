package leetcode.easy.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_040_BottomK
 * Author:   Xu Qinkun
 * Date:     2020/3/20 10:19
 * Description: 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */

public class Exc_040_BottomK {
    private static final int MAX = 10001;

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0)
            return new int[0];
        int[] count = new int[MAX];
        int n = arr.length;
        for (int value : arr) {
            count[value]++;
        }
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < MAX && j < k; i++) {
            while (j < k && count[i] != 0) {
                ans[j++] = i;
                count[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_040_BottomK bk = new Exc_040_BottomK();
        int[] a = {};
        int k = 3;
        System.out.println(Arrays.toString(bk.getLeastNumbers(a, k)));
    }
}
