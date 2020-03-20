package leetcode.medium.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_016_ThreeSumCloset
 * Author:   Xu Qinkun
 * Date:     2020/3/19 9:53
 * Description:最接近的三数之和
 */

public class Exc_016_ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2], sum;

        int j, k;
        for (int i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return sum;
                else if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_016_ThreeSumCloset ts = new Exc_016_ThreeSumCloset();
        int[] a = {-1,2,1,-4};
        System.out.println(ts.threeSumClosest(a, 1));
    }
}
