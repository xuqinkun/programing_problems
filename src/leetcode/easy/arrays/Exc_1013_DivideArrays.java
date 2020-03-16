package leetcode.easy.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1013_DivideArrays
 * Author:   Xu Qinkun
 * Date:     2020/3/16 11:08
 * Description: 将数组分成和相等的三个部分
 */

public class Exc_1013_DivideArrays {

    private static final int PARTS = 3;

    public boolean canThreePartsEqualSum(int[] a) {
        int n = a.length;
        if (n == 0) return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        if (sum % PARTS != 0) return false;
        int div = sum / PARTS, tmp;
        int i = 0;
        for (int j = 0; j < PARTS - 1; j++) {
            tmp = a[i++];
            while (i < n && div != tmp) tmp += a[i++];
            if (i == n) return false;
        }
        tmp = 0;
        while (i < n) tmp += a[i++];
        return tmp == div;
    }

    public static void main(String[] args) {
        Exc_1013_DivideArrays da = new Exc_1013_DivideArrays();
        int[] a = {12,-4,16,-5,9,-3,3,8,0};
        System.out.println(da.canThreePartsEqualSum(a));
    }
}
