package leetcode.medium.arrays;

import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

class Pair {
    int num;
    int pos;

    public Pair(int num, int pos) {
        this.num = num;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "num=" + num +
                ", pos=" + pos +
                '}';
    }
}

public class Exc_1438_LongestSubArray {

    public int longestSubarray(int[] nums, int limit) {
        int maxLen = 1;
        SortedMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Exc_1438_LongestSubArray lsa = new Exc_1438_LongestSubArray();
        System.out.println(lsa.longestSubarray(new int[]{4,2,2,2,4,4,2,2,1,2,3,4,5,1,1,1,1,1,1,1,1}, 0));
    }
}
