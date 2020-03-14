package leetcode.medium.arrays;

public class Exc_081_SearchInSortedArray {

    public boolean search(int[] a, int target) {
        int lo = 0, hi = a.length - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (a[mid] == target) {
                return true;
            }
            int idx = mid;
            if (a[mid] == a[hi]) {
                while (idx < hi && a[idx] == a[hi]) idx++;
                if (idx == hi) {
                    hi = mid - 1;
                } else {
                    lo = idx;
                }
                continue;
            }
            if (target < a[mid]) {
                if (a[mid] >= a[hi] && target <= a[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (a[mid] <= a[hi] && target > a[hi])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exc_081_SearchInSortedArray sis = new Exc_081_SearchInSortedArray();
        int[] a = {2,5,6,0,0,1,2};
        int t = 2;
        System.out.println(sis.search(a, t));
    }
}
