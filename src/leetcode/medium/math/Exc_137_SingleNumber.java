package leetcode.medium.math;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Exc_137_SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for(int n : nums)
                total += (n >> i) &1;
            if (total % 3 != 0)
                ans |= (1<<i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_137_SingleNumber sn = new Exc_137_SingleNumber();
        System.out.println(sn.singleNumber(new int[]{2, 2, 2, 3}));
        System.out.println(sn.singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
