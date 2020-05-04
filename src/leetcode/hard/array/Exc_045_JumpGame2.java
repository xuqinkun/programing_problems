package leetcode.hard.array;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_045_JumpGame2
 * Author:   Xu Qinkun
 * Date:     2020/5/4 9:36
 * Description: 跳跃游戏 II
 */

public class Exc_045_JumpGame2 {

    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0, maxPosition = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Exc_045_JumpGame2 jg = new Exc_045_JumpGame2();
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(jg.jump(a));
    }
}
