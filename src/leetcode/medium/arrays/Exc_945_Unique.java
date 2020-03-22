package leetcode.medium.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_945_Unique
 * Author:   Xu Qinkun
 * Date:     2020/3/22 8:42
 * Description: 使数组唯一的最小增量
 */

public class Exc_945_Unique {

    private static final int MAX_LEN = 40001;

    public int minIncrementForUnique(int[] a) {
        if (a == null || a.length == 0) return 0;
        int [] count = new int[MAX_LEN];
        int n = a.length;
        for (int value : a) {
            count[value]++;
        }
        int from = 0, to, last = 0, step = 0;
        while (from < n) {
            if (count[from] > 1) {
                to = Math.max(last, from) + 1;
                while (to < MAX_LEN && count[to] != 0) to++;
                last = to;
                step += (to - from);
                count[from]--;
                if (to < MAX_LEN)
                    count[to]++;
            } else {
                from++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Exc_945_Unique uni = new Exc_945_Unique();
        int[] a = {1,1,0,0,0,0};
        System.out.println(uni.minIncrementForUnique(a));
    }
}
