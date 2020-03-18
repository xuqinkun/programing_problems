package leetcode.medium.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_457_CircularArrayLoop
 * Author:   Xu Qinkun
 * Date:     2020/3/18 9:48
 * Description: 环形数组循环
 */

public class Exc_457_CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        for (int i = 0; i < n; i++) {
            if (detectCycle(nums, i, n))
                return true;
        }
        return false;
    }

    private boolean detectCycle(int[] nums, int i, int n) {
        int slow = nextIndex(i, nums[i], n);
        int fast = nextIndex(slow, nums[slow], n);
        while (slow != fast) {
            slow = nextIndex(slow, nums[slow], n);
            int tmp = nextIndex(fast, nums[fast], n);
            fast = nextIndex(tmp, nums[tmp], n);
        }
        int p = i, q = slow;
        while (p != q) {
            p = nextIndex(p, nums[p], n);
            q = nextIndex(q, nums[q], n);
        }
        q = nextIndex(p, nums[p], n);
        if (p == q) return false;
        while (p != q) {
            if ((nums[p] > 0 && nums[q] < 0) || (nums[p] < 0 && nums[q] > 0))
                return false;
            q = nextIndex(q, nums[q], n);
        }
        return true;
    }

    private int nextIndex(int currIndex, int k, int n) {
        k += currIndex;
        if (k >= 0) return k % n;
        else {
            while (k < 0)
                k += n;
            return k;
        }
    }

    public static void main(String[] args) {
        Exc_457_CircularArrayLoop ca = new Exc_457_CircularArrayLoop();
        int[] a = {-2,1,-1,-2,-2};
        System.out.println(ca.circularArrayLoop(a)); // false
        int [] b = {3,1,2};
        System.out.println(ca.circularArrayLoop(b)); // true
        int [] c = {2,-1,1,2,2};
        System.out.println(ca.circularArrayLoop(c)); // true
        int [] d = {-1, 2};
        System.out.println(ca.circularArrayLoop(d)); // false
        int [] e = {2,-1,1,-2,-2};
        System.out.println(ca.circularArrayLoop(e)); // false
        int [] f = {-1,-1,-1};
        System.out.println(ca.circularArrayLoop(f)); // true
    }
}
