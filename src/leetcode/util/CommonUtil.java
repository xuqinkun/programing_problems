package leetcode.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: XuQinkun
 * @create: 2024-10-01 16:03
 **/
public class CommonUtil {

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static int[] getRandomNums(int n) {
        Random random = new Random(n);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(n * 10);
        }
        return nums;
    }
}
