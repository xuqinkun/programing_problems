package leetcode.util;


import static leetcode.util.CommonUtil.getRandomNums;
import static leetcode.util.CommonUtil.swap;

/**
 * @description: 排序算法汇总
 * @author: XuQinkun
 * @create: 2024-10-01 17:50
 **/
public class SortUtil {

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n; i >= 0; i--) {
            boolean flag = true;
            for (int j = 0; j + 1 < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j+1);
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    k = j;
                    min = nums[j];
                }
            }
            swap(nums, i, k);
        }
    }

    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public static void mergeSort(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int[] tempArr = new int[n];
        mergeSort(nums, tempArr, lo, hi);
    }

    private static void mergeSort(int[] nums, int[] tempArr, int lo, int hi) {
        if (lo >= hi) return;
        int m = (lo + hi) / 2;
        mergeSort(nums, tempArr, lo, m);
        mergeSort(nums, tempArr, m + 1, hi);
        int i = lo, j = m + 1;
        int c = lo;
        while (i <= m && j <= hi) {
            int left = nums[i];
            int right = nums[j];
            if (left < right) {
                tempArr[c] = left;
                i++;
            } else {
                tempArr[c] = right;
                j++;
            }
            c++;
        }
        while (i <= m)
            tempArr[c++] = nums[i++];
        while (j <= hi)
            tempArr[c++] = nums[j++];
        for (int k = lo; k <= hi; k++) {
            nums[k] = tempArr[k];
        }
    }

    private static boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = getRandomNums(10000);
        //System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(isSorted(nums));
    }
}
