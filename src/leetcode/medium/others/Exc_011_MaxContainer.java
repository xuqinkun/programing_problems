package leetcode.medium.others;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 思路：两边向中间移动时，中间的高度必须要大于两边的高度，才有可能称为最优解
 *
 */
public class Exc_011_MaxContainer {

    /**
     * My solution
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int h1 = height[left];
            int h2 = height[right];
            int h = Math.min(h1, h2);
            int area = (right - left) * h;
            max = Math.max(max, area);
            while (left < right && height[left] <= h) {
                left++;
                h1 = height[left];
                h = Math.min(h1, h2);
                area = (right - left) * h;
                max = Math.max(max, area);
            }
            while (left < right && height[right] <= h) {
                right--;
                h2 = height[right];
                h = Math.min(h1, h2);
                area = (right - left) * h;
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     *
     * public int maxArea(int[] height) {
     *         int maxarea = 0, l = 0, r = height.length - 1;
     *         while (l < r) {
     *             maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
     *             if (height[l] < height[r])
     *                 l++;
     *             else
     *                 r--;
     *         }
     *         return maxarea;
     *     }
     *
     * @param args
     */

    public static void main(String[] args) {
        Exc_011_MaxContainer mc = new Exc_011_MaxContainer();
        System.out.println(mc.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(mc.maxArea(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(mc.maxArea(new int[]{9,8,7,6,5,4,3,2,1}));
    }

}
