package leetcode.medium.arrays;

import java.util.HashMap;
import java.util.Map;

public class Exc_128_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int left = 0, right = 0, currLen = 0;
            if (!map.containsKey(curr)) {
                left = map.getOrDefault(curr - 1, 0);
                right = map.getOrDefault(curr + 1, 0);
                currLen = right + left + 1;
                maxLen = Math.max(maxLen, currLen);
                map.put(curr, currLen);
                map.put(curr - left, currLen);
                map.put(curr + right, currLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Exc_128_LongestConsecutive lc = new Exc_128_LongestConsecutive();
        System.out.println(lc.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(lc.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
