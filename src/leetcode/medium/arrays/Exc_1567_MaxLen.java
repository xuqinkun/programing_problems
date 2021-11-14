package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

public class Exc_1567_MaxLen {

    public static void main(String[] args) {
        Exc_1567_MaxLen ml = new Exc_1567_MaxLen();
        System.out.println(ml.getMaxLen(new int[]{0, 1, -2, -3, 4, 1, 0, -2, -3, 4}) == 5);
        System.out.println(4==ml.getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(ml.getMaxLen(new int[]{0, 1, -2, -3, 4}) == 4);
        System.out.println(8 == ml.getMaxLen(new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2}));
        System.out.println(ml.getMaxLen(new int[]{0, 1, -2, -3, -4}) == 3);
        System.out.println(ml.getMaxLen(new int[]{-1, -2, -3, 0, 1}) == 2);
        System.out.println(ml.getMaxLen(new int[]{-1, 2}) == 1);
        System.out.println(ml.getMaxLen(new int[]{-1, -2}) == 2);
        System.out.println(ml.getMaxLen(new int[]{2}) == 1);
        System.out.println(ml.getMaxLen(new int[]{-1}) == 0);
        System.out.println(ml.getMaxLen(new int[]{0}) == 0);
    }

    public int getMaxLen(int[] nums) {
        int l = 0;
        int maxLen = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                maxLen = Math.max(maxLenSegment(l, i - 1, nums), maxLen);
                l = i + 1;
            }
        }
        if (l == len) return maxLen;
        if (l == 0) return maxLenSegment(0, len - 1, nums);
        else return Math.max(maxLenSegment(l, len - 1, nums), maxLen);
    }

    private int maxLenSegment(int l, int r, int[] nums) {
        List<Integer> negNumPosList = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (nums[i] < 0)
                negNumPosList.add(i);
        }
        int size = negNumPosList.size();
        if (size % 2 == 0) {
            return r - l + 1;
        }
        if (size == 1) {
            Integer pos = negNumPosList.get(0);
            return Math.max(pos - l, r - pos);
        } else {
            Integer leftMost = negNumPosList.get(0);
            Integer rightMost = negNumPosList.get(size - 1);
            return Math.max(r - leftMost, rightMost - l);
        }
    }
}
