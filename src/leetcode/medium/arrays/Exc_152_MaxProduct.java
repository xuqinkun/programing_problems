package leetcode.medium.arrays;

public class Exc_152_MaxProduct {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, start = 0, tmp;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                tmp = maxProduct(nums, start, i - 1);
                max = Math.max(Math.max(tmp, 0), max);
                start = i + 1;
            }
        }
        tmp = maxProduct(nums, start, n - 1);
        max = Math.max(tmp, max);
        return max;
    }

    private int maxProduct(int[] nums, int lo, int hi) {
        if (lo > hi) return 0;
        int max = Integer.MIN_VALUE, tmp = 1;
        for (int i = lo; i <= hi; i++) {
            tmp *= nums[i];
            if (tmp > max)
                max = tmp;
        }
        for (int i = lo; i < hi; i++) {
            tmp /= nums[i];
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        Exc_152_MaxProduct mp = new Exc_152_MaxProduct();
        int[] a = {1,0,0,0};
        System.out.println(mp.maxProduct(a));
    }
}
