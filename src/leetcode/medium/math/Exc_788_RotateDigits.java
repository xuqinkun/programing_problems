package leetcode.medium.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_788_RotateDigits
 * Author:   Xu Qinkun
 * Date:     2020/4/17 9:17
 * Description: 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
 * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 */

public class Exc_788_RotateDigits {
    static final List<Integer> NONE_GOOD_NUMS = Arrays.asList(0, 1, 8);
    static final List<Integer> GOOD_NUMS = Arrays.asList(2, 5, 6, 9);
    static boolean[] IS_GOOD_NUM = new boolean[10001];

    static {
        List<Integer> nums = new ArrayList<>();
        nums.addAll(NONE_GOOD_NUMS);
        nums.addAll(GOOD_NUMS);
        for (int i = 1; i <= 4; i++) {
            combination(nums, 0, i, new ArrayList<>(), IS_GOOD_NUM, true);
        }
        for (int i = 1; i <= 4; i++) {
            combination(NONE_GOOD_NUMS, 0, i, new ArrayList<>(), IS_GOOD_NUM, false);
        }
    }

    private static void combination(List<Integer> goodNums, int start, int len,
                                    ArrayList<Integer> tempList, boolean[] isGoodNum, boolean isGood) {
        if (tempList.size() == len) {
            isGoodNum[listToInteger(tempList)] = isGood;
            return;
        }
        for (int i = start; i < goodNums.size(); i++) {
            tempList.add(goodNums.get(i));
            combination(goodNums, start, len, tempList, isGoodNum, isGood);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static int listToInteger(List<Integer> list) {
        int ans = 0;
        for (int n : list) {
            ans = ans * 10 + n;
        }
        return ans;
    }

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (IS_GOOD_NUM[i]) {
                System.out.printf("====%d is good num IS_GOOD_NUM[%d]==%b\n", i, i, IS_GOOD_NUM[i]);
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_788_RotateDigits rd = new Exc_788_RotateDigits();
        System.out.println(rd.rotatedDigits(1000));
    }

}