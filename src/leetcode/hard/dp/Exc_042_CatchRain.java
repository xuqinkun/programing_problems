package leetcode.hard.dp;

import java.util.Stack;

public class Exc_042_CatchRain {

    public static void main(String[] args) {
        Exc_042_CatchRain cr = new Exc_042_CatchRain();
        System.out.println(cr.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(cr.trap(new int[]{0, 1, 0}));
        System.out.println(cr.trap(new int[]{0, 1, 2}));
        System.out.println(cr.trap(new int[]{2, 1, 2}));
        System.out.println(cr.trap(new int[]{2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(cr.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        Stack<Rectangle> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            while (stack.size() >= 2 && curr > stack.peek().height) {
                Rectangle middle = stack.pop();
                Rectangle left = stack.peek();
                int low = middle.height;
                int h = left.height;
                int deep = Math.min(curr, h) - low;
                sum += Math.max(deep, 0) * (i - left.index - 1);
            }
            stack.push(new Rectangle(i, curr));
        }
        return sum;
    }

    class Rectangle {
        int index;
        int height;

        public Rectangle(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
