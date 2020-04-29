package leetcode.hard.search;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1095_FindInMountainArray
 * Author:   Xu Qinkun
 * Date:     2020/4/29 10:10
 * Description: 山脉数组中查找目标值
 */

interface MountainArray {
    public int get(int index);

    public int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] a;
    private int size;

    public MountainArrayImpl(int[] a) {
        size = a.length;
        this.a = new int[size];
        System.arraycopy(a, 0, this.a, 0, size);
    }

    @Override
    public int get(int index) {
        return a[index];
    }

    @Override
    public int length() {
        return size;
    }
}

public class Exc_1095_FindInMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int index = binarySearch(target, mountainArr, 0, l, true);
        if (index != -1) return index;
        return binarySearch(target, mountainArr, l, mountainArr.length() - 1, false);
    }

    private int binarySearch(int target, MountainArray mountainArr, int l, int r, boolean isAscending) {
        while (l <= r) {
            int mid = (l + r) / 2;
            int peek = mountainArr.get(mid);
            if (peek == target) return mid;
            else if (peek > target && isAscending || peek < target && !isAscending) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] a = {3, 5, 3, 2, 0};
//        int[] a = {1, 2, 3, 4, 5, 3, 1};
//        int[] a = {0, 1, 2, 4, 2, 1};
//        int[] a = {1, 2, 3, 2, 1};
        int[] a = {1, 5, 2};
        MountainArray m = new MountainArrayImpl(a);
        Exc_1095_FindInMountainArray fi = new Exc_1095_FindInMountainArray();
        System.out.println(fi.findInMountainArray(2, m));
    }
}
