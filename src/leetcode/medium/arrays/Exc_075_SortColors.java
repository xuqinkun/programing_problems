package leetcode.medium.arrays;

import java.util.Arrays;

import static leetcode.util.CommonUtil.swap;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class Exc_075_SortColors {

    public static void main(String[] args) {
        Exc_075_SortColors sc = new Exc_075_SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sc.sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

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
            } else if (nums[curr] == 2) {
                tmp = nums[p2];
                nums[p2--] = nums[curr];
                nums[curr] = tmp;
            } else {
                curr++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int i = 0;
        int lo = 0;
        int hi = len - 1;
        while (i <= hi) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, i, lo);
                lo++;
                i++;
            } else {
                swap(nums, i, hi);
                hi--;
            }
        }
    }
}
