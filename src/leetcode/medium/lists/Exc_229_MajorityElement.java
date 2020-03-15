package leetcode.medium.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_229_MajorityElement
 * Author:   Xu Qinkun
 * Date:     2020/3/15 11:39
 * Description:
 */

public class Exc_229_MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;
        int first = 0, second = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == first) {
                count1++;
                continue;
            }
            if (num == second) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                first = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                second = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = count(nums, first);
        count2 = count(nums, second);
        if (count1 > n / 3) ans.add(first);
        if (first != second && count2 > n / 3) ans.add(second);
        return ans;
    }

    private int count(int[] nums, int target) {
        int count = 0, n = nums.length;
        for (int num : nums) {
            if (num == target)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Exc_229_MajorityElement me = new Exc_229_MajorityElement();
        int[] a = {1,1,1,1,2,2,2,2,3,4,5,6};
        System.out.println(me.majorityElement(a));
    }
}
