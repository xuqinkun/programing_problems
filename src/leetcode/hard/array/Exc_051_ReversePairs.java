package leetcode.hard.array;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_051_ReversePairs
 * Author:   Xu Qinkun
 * Date:     2020/4/24 9:51
 * Description: 数组中的逆序对
 */

public class Exc_051_ReversePairs {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, new int[n], 0, n - 1);
    }

    private int mergeSort(int[] nums, int[] tmp, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        int inv_count = mergeSort(nums, tmp, l, mid) + mergeSort(nums, tmp, mid + 1, r);
        int i = l, j = mid + 1, pos = l;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[pos] = nums[i];
                ++i;
                inv_count += (j - (mid + 1));
            } else {
                tmp[pos] = nums[j++];
            }
            pos++;
        }
        for (int k = i; k <= mid; ++k) {
            tmp[pos++] = nums[k];
            inv_count += (j - (mid + 1));
        }
        for (int k = j; k <= r; ++k) {
            tmp[pos++] = nums[k];
        }
        System.arraycopy(tmp, l, nums, l, r + 1 - l);
        return inv_count;
    }

    public static void main(String[] args) {
        Exc_051_ReversePairs rp = new Exc_051_ReversePairs();
        System.out.println(rp.reversePairs(new int[]{}));
    }
}
