package leetcode.easy.arrays;

import java.util.Arrays;

public class Exc_561_ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i * 2];
        }
        return sum;
    }

    public static void main(String[] args) {
        Exc_561_ArrayPairSum sol = new Exc_561_ArrayPairSum();
        System.out.println(sol.arrayPairSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
