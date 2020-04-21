package leetcode.medium.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1248_SubArray
 * Author:   Xu Qinkun
 * Date:     2020/4/21 8:14
 * Description:
 */

public class Exc_1248_SubArray {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, cnt = 0;
        int[] indexOfOdds = new int[n + 2];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (isOdd(nums[i])) {
                indexOfOdds[++j] = i;
            }
        }
        indexOfOdds[0] = -1;
        indexOfOdds[++j] = n;
        for (int i = 1; i + k <= j; i++) {
            int l = indexOfOdds[i] - indexOfOdds[i - 1];
            int r = indexOfOdds[i + k] - indexOfOdds[i + k - 1];
            cnt += (l * r);
        }
        return cnt;
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static void main(String[] args) {
        Exc_1248_SubArray sa = new Exc_1248_SubArray();
        int[] a = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(sa.numberOfSubarrays(a, 3));
    }
}
