package leetcode.medium.arrays;

public class Exc_162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 0;
        int l = 0, r = n - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            int pivot = nums[mid];
            if (mid == 0 && pivot > nums[1]) return 0;
            else if (mid == 0 && pivot < nums[1]) l = mid + 1;
            else if (mid == n - 1 && pivot > nums[mid - 1]) return mid;
            else if (mid == n - 1 && pivot < nums[mid - 1]) r = mid - 1;
            else if (pivot > nums[mid - 1] && pivot > nums[mid + 1]) return mid;
            else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Exc_162_FindPeakElement fp = new Exc_162_FindPeakElement();
        int[] a = {1,2,3,1};
        System.out.println(fp.findPeakElement(a));
    }
}
