package leetcode.medium.math;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 思路：两边向中间移动时，中间的高度必须要大于两边的高度，才有可能称为最优解
 */
public class Exc_011_MaxContainer {

    /**
     * My solution
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0, area;
        int left = 0, right = height.length - 1;
        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left]<height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Exc_011_MaxContainer mc = new Exc_011_MaxContainer();
        System.out.println(mc.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(mc.maxArea(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(mc.maxArea(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

}
