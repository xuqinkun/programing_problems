package leetcode.medium.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_912_SortArray
 * Author:   Xu Qinkun
 * Date:     2020/3/31 9:36
 * Description: 排序数组
 */

public class Exc_912_SortArray {

    private Random rand = new Random();

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        sort(nums, 0, n - 1);
        return nums;
    }

    public int[] sortArray2(int[] nums) {
        int n = nums.length;
        sort2(nums, 0, n - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int k = randomPartition(nums, left, right);
        sort(nums, left, k - 1);
        sort(nums, k + 1, right);
    }

    private void sort2(int[] nums, int left, int right) {
        if (left >= right) return;
        int k = partition(nums, left, right);
        sort(nums, left, k - 1);
        sort(nums, k + 1, right);
    }

    private int randomPartition(int[] nums, int left, int right) {
        int i = rand.nextInt(right - left) + left;
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) left++;
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        Exc_912_SortArray sa = new Exc_912_SortArray();
        Random rand = new Random();
        int n = 1000000;
        int j = 0;
        double time1 = 0, time2 = 0;
        int[] a = new int[n], b = new int[n];
        while (j++ < 1000) {
            for (int i = 0; i < n; i++) {
                a[i] = rand.nextInt(n);
                b[i] = rand.nextInt(n);
            }
            long start1 = System.currentTimeMillis();
            sa.sortArray(a);
            long end1 = System.currentTimeMillis();
            long start2 = System.currentTimeMillis();
            sa.sortArray2(b);
            long end2 = System.currentTimeMillis();
            time1 += (end1 - start1);
            time2 += (end2 - start2);
            System.out.printf("================Round %d================\n", j);
            System.out.printf("Random-method takes %d ms\n", end1 - start1);
            System.out.printf("Non-random-method takes %d ms\n", end2 - start2);
        }
        System.out.printf("Random-method avg takes %f ms\n", time1 / j);
        System.out.printf("Non-random-method avg takes %f ms\n", time2 / j);
    }
}
