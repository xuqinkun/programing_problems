package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c
 * in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class Exc_15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return results;
        }
        int n = nums.length;
        sort(nums);
        int last = Integer.MIN_VALUE;
        for (int i = 0 ; i < n - 2; i++) {
            int x = nums[i];
            if (last == x) {
                continue;
            } else {
                last = x;
            }
            int t = -x;
            int l = i + 1, r = n - 1;
            // 当前值等于0，下一个数大于0，则不可能存在以i开头且和为0的序列
            if ((x == 0 && nums[l] > 0) || x > 0) {
                break;
            }
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < t) {
                    while (l < r && nums[l] + nums[r] < t) {
                        l++;
                    }
                }
                else if (sum > t){
                    while (l < r && nums[l] + nums[r] > t) {
                        r--;
                    }
                }
                else {
                    List<Integer> ret = new ArrayList<>();
                    ret.add(nums[i]); ret.add(nums[l]); ret.add(nums[r]);
                    results.add(ret);
                    // jump duplicate
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    // jump duplicate
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++; r--;
                }
            }
        }
        return results;
    }

    private void sort(int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
//        System.out.println(new Exc_15_ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(new Exc_15_ThreeSum().threeSum(new int[]{0, 0, 0, 0}));
//        System.out.println(new Exc_15_ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2}));
        System.out.println(new Exc_15_ThreeSum().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

}
