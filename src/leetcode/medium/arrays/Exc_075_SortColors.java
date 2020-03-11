package leetcode.medium.arrays;

import java.util.Arrays;

public class Exc_075_SortColors {

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len == 0) return;
        int p0 = 0, p2 = len - 1, curr = 0;
        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                tmp = nums[p2];
                nums[p2--] = nums[curr];
                nums[curr] = tmp;
            }
            else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        Exc_075_SortColors sc = new Exc_075_SortColors();
        int[] nums = {2,0,2,1,1,0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
