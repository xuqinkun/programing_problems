package leetcode.medium.arrays;

import java.util.Arrays;

public class Exc_034_SearchInRange {
    public int[] searchRange(int[] a, int target) {
        int[] ans = new int[]{-1, -1};
        int lo, hi, mid, len = a.length;

        if (len == 0) {
            return ans;
        }
        // left
        if (a[0] == target) {
            ans[0] = 0;
        }
        else {
            lo = 1;
            hi = len - 1;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (mid + 1 < len && a[mid + 1] == target && a[mid] < target) {
                    ans[0] = mid + 1;
                    break;
                }
                else if (a[mid - 1] < target && a[mid] == target) {
                    ans[0] = mid;
                    break;
                }
                else if (a[mid] > target || (a[mid - 1] == target && a[mid] == target)) {
                    hi = mid - 1;
                }
                else if (a[mid] < target) {
                    lo = mid + 1;
                }
            }
        }

        // right
        if (a[len - 1] == target) {
            ans[1] = len - 1;
        }
        else {
            lo = 0;
            hi = len - 2;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (mid > 0 && a[mid - 1] == target && a[mid] > target) {
                    ans[1] = mid - 1;
                    break;
                }
                else if (a[mid] == target && a[mid + 1] > target) {
                    ans[1] = mid;
                    break;
                }
                else if (a[mid] > target) {
                    hi = mid - 1;
                }
                else if (a[mid] < target || (a[mid] == target && a[mid + 1] == target)) {
                    lo = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_034_SearchInRange sr = new Exc_034_SearchInRange();
        int[] a = new int[]{1,2,8,8,8,8,8,8,8,8,9,10};
        System.out.println(Arrays.toString(sr.searchRange(a, 0)));
        System.out.println(Arrays.toString(sr.searchRange(a, 6)));
        System.out.println(Arrays.toString(sr.searchRange(a, 12)));
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(sr.searchRange(a, a[i])));
        }
    }

}
