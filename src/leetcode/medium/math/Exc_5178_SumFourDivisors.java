package leetcode.medium.math;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_5178_SumFourDivisors
 * Author:   Xu Qinkun
 * Date:     2020/3/22 10:45
 * Description:
 */

public class Exc_5178_SumFourDivisors {

    private static final int MAX_LEN = 100001;
    static int[] counts = new int[MAX_LEN];
    static int[] sums = new int[MAX_LEN];

    static {
        for (int i = 1; i < MAX_LEN; i++) {
            int count = 0, sum = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (i / j != j) {
                        count += 2;
                        sum += (j + i / j);
                    }
                    else {
                        sum += j;
                        count++;
                    }
                }
            }
            counts[i] = count;
            sums[i] = sum;
        }
    }

    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (counts[nums[i]] == 4)
                sum += sums[nums[i]];
        }
        return sum;
    }

    public static void main(String[] args) {
        Exc_5178_SumFourDivisors sd = new Exc_5178_SumFourDivisors();
        int[] a = {21,4,7};
        System.out.println(sd.sumFourDivisors(a));
    }
}
