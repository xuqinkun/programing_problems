package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_046_Permutation
 * Author:   Xu Qinkun
 * Date:     2020/4/25 9:35
 * Description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */

public class Exc_046_Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        permute(nums, n, 0, ans);
        return ans;
    }

    private void permute(int[] nums, int n, int start, List<List<Integer>> ans) {
        if (start == n) {
            ans.add(addAll(nums));
        }
        for (int i = start; i < n; i++) {
            swap(nums, i, start);
            permute(nums, n, start + 1, ans);
            swap(nums, i, start);
        }
    }

    private List<Integer> addAll(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int val : nums)
            list.add(val);
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Exc_046_Permutation perm = new Exc_046_Permutation();
        System.out.println(perm.permute(new int[]{}));
    }
}
