package leetcode.medium.double_pointers;

import java.util.Arrays;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，
 * 该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 */
public class Exc_167_TwoSumOfTarget {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                break;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        Exc_167_TwoSumOfTarget ts = new Exc_167_TwoSumOfTarget();
        int[] nums = ts.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(nums));
        nums = ts.twoSum(new int[]{2,3,4}, 6);
        System.out.println(Arrays.toString(nums));
    }
}
