package leetcode.easy.arrays;

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 */
public class Exc_697_FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 50000;
        int[] leftPos = new int[maxLen];
        int[] rightPos = new int[maxLen];
        Arrays.fill(leftPos, -1);
        Arrays.fill(rightPos, -1);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int maxFreq = 0;
        for (int num : map.keySet()) {
            if (map.get(num) > maxFreq) {
                maxFreq = map.get(num);
            }
        }
        List<Integer> candidateNums = new ArrayList<>();
        for (int num : map.keySet()) {
            if (map.get(num) == maxFreq) {
                candidateNums.add(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftPos[nums[i]] == -1)
                leftPos[nums[i]] = i;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (rightPos[nums[i]] == -1)
                rightPos[nums[i]] = i;
        }
        int minSubArrayLen = maxLen;
        for (int num : candidateNums) {
            int len = rightPos[num] - leftPos[num] + 1;
            if (len < minSubArrayLen)
                minSubArrayLen = len;
        }
        return minSubArrayLen;
    }

    public static void main(String[] args) {
        Exc_697_FindShortestSubArray exc = new Exc_697_FindShortestSubArray();
        System.out.println(exc.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(exc.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(exc.findShortestSubArray(new int[]{1, 2, 2, 49999,49999,3, 1,49999}));
    }
}
