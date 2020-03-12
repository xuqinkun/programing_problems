package leetcode.medium.arrays;

public class Exc_053_MinimumInRotateArrays {

    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int l = 0, r = n - 1, mid;
        if (nums[l] < nums[r]) return nums[l];
        while (l < r) {
            mid = l + (r - l) / 2;
            int pivot = nums[mid];
            if (mid > 0 && mid < r
                    && pivot < nums[mid - 1]
                    && pivot < nums[mid + 1])
                return pivot;
            if (pivot > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Exc_053_MinimumInRotateArrays ma = new Exc_053_MinimumInRotateArrays();
        int[] a = {5,6,7,8,9,0,1,2,3,4};
        System.out.println(ma.findMin(a));
    }
}
