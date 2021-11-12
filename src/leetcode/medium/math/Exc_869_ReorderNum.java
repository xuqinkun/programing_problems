package leetcode.medium.math;

import java.util.HashSet;
import java.util.Set;

public class Exc_869_ReorderNum {
    private Set<String> powerNumSet = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        init();
        return powerNumSet.contains(countDigits(n));
    }

    private void init() {
        for (int i = 1; i <= 1e9; i <<= 1) {
            powerNumSet.add(countDigits(i));
        }
    }

    private String countDigits(int n) {
        char [] nums = new char[32];

        while (n > 0) {
            nums[n % 10]++;
            n /= 10;
        }
        return new String(nums);
    }

    public static void main(String[] args) {
        Exc_869_ReorderNum rn = new Exc_869_ReorderNum();
        System.out.println(rn.reorderedPowerOf2(16));
        System.out.println(rn.reorderedPowerOf2(1));
        System.out.println(!rn.reorderedPowerOf2(21));
        System.out.println(!rn.reorderedPowerOf2(999999999));
    }
}
