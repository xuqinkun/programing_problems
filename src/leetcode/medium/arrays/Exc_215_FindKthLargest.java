package leetcode.medium.arrays;


import java.util.Random;

public class Exc_215_FindKthLargest {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int i;
        while ((i = partition(nums, low, high)) != n - k) {
            if (i > n - k) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return nums[i];
    }

    private int partition(int[] a, int low, int high) {
        if (low >= high) return low;
        int t = rand.nextInt(high - low + 1) + low;
        swap(a, t, low);
        int p = a[low];
        int l = low + 1, r = high;
        while (l <= r) {
            while (l <= high && a[l] <= p) l++;
            while (r >= 0 && a[r] > p) r--;
            if (l < r)
                swap(a, l, r);
        }
        swap(a, low, r);
        return r;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Exc_215_FindKthLargest fl = new Exc_215_FindKthLargest();
        int[] nums = {3,2,3,1,2,4,5,5,6};
//        int[] nums = {2};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(fl.findKthLargest(nums, i+1));
        }
    }
}
