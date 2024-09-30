package leetcode.medium.double_pointers;

import java.util.Arrays;

public class Exc_088_MergeTwoArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 > num2) {
                nums1[k--] = num1;
                i--;
            } else {
                nums1[k--] = num2;
                j--;
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Exc_088_MergeTwoArrays mt = new Exc_088_MergeTwoArrays();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        mt.merge(nums1, 3, new int[]{1, 2, 3}, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1};
        mt.merge(nums1, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{0};
        mt.merge(nums1, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{2, 0};
        mt.merge(nums1, 1, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
