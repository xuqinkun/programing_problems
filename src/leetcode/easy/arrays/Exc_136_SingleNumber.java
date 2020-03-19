package leetcode.easy.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_136_SingleNumber
 * Author:   Xu Qinkun
 * Date:     2020/3/19 10:11
 * Description: 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 */

public class Exc_136_SingleNumber {

    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_136_SingleNumber sn = new Exc_136_SingleNumber();
        int[] a = {1};
        System.out.println(sn.singleNumber(a));
    }
}
