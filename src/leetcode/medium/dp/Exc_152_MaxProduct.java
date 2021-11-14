package leetcode.medium.dp;

public class Exc_152_MaxProduct {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxProds = new int[len];
        int[] minProds = new int[len];
        maxProds[0] = nums[0];
        minProds[0] = nums[0];
        int maxVal = nums[0];
        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            maxProds[i] = Math.max(Math.max(maxProds[i - 1] * curr, minProds[i - 1] * curr), curr);
            minProds[i] = Math.min(Math.min(maxProds[i - 1] * curr, minProds[i - 1] * curr), curr);
            maxVal = Math.max(maxVal, maxProds[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Exc_152_MaxProduct mp = new Exc_152_MaxProduct();
        System.out.println(mp.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(mp.maxProduct(new int[]{2, 3, -2, 4,-1}));
        System.out.println(mp.maxProduct(new int[]{-2,0,-1}));
        System.out.println(mp.maxProduct(new int[]{-2}));
        System.out.println(mp.maxProduct(new int[]{-2,-1}));
    }
}
