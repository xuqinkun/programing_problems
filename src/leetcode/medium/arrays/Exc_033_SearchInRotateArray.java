package leetcode.medium.arrays;

public class Exc_033_SearchInRotateArray {

    public int search(int[] a, int target) {
        int lo = 0, hi = a.length - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (target < a[mid]) {
                if (a[mid] > a[hi] && target <= a[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (a[mid] < a[hi] && target > a[hi])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Exc_033_SearchInRotateArray sr = new Exc_033_SearchInRotateArray();
        int[] a = new int[]{10,1,2,5,9};
//        System.out.println(sr.search(a, 8));
        for (int i = 0; i < a.length; i++) {
            System.out.println(sr.search(a, a[i]));
        }
    }
}
