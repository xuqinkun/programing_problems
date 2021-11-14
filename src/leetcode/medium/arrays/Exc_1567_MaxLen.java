package leetcode.medium.arrays;

public class Exc_1567_MaxLen {

    public static void main(String[] args) {
        Exc_1567_MaxLen ml = new Exc_1567_MaxLen();
        System.out.println(ml.getMaxLen(new int[]{0, 1, -2, -3, 4, 1, 0, -2, -3, 4}) == 5);
        System.out.println(4 == ml.getMaxLen(new int[]{1, -2, -3, 4}));
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
        int len = nums.length;
        int[] positive = new int[len]; // positive[i]表示乘积为正的子数组长度
        int[] negative = new int[len]; // positive[i]表示乘积为负的子数组长度
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLen = positive[0];
        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            if (curr > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (curr < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLen = Math.max(maxLen, positive[i]);
        }
        return maxLen;
    }


}
