package leetcode.medium.arrays;

import java.util.Arrays;

public class Exc_031_NextPermutation {

    public static void main(String[] args) {
        Exc_031_NextPermutation np = new Exc_031_NextPermutation();
        int[] nums = {5,1,1};
        System.out.println(Arrays.toString(nums));
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2, j = n - 1;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            while (j >= 1 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        int mid = (right + left) / 2;
        for (int i = left; i <= mid; i++) {
            swap(nums, i, right - i + left);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
