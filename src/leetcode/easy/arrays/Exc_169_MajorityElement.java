package leetcode.easy.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_169_MajorityElement
 * Author:   Xu Qinkun
 * Date:     2020/3/16 11:50
 * Description: 多数元素
 */

public class Exc_169_MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
                continue;
            }
            if (candidate == num) count++;
            else count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Exc_169_MajorityElement me = new Exc_169_MajorityElement();
        int[] a = {3,3,4};
        System.out.println(me.majorityElement(a));
    }

}
