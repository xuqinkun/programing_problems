package leetcode.easy.arrays;

import java.util.LinkedList;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_5364_InsertArray
 * Author:   Xu Qinkun
 * Date:     2020/3/22 10:40
 * Description:
 */

public class Exc_5364_InsertArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            list.add(index[i], nums[i]);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_5364_InsertArray ia = new Exc_5364_InsertArray();

    }
}
