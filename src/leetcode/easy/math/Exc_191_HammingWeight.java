package leetcode.easy.math;

import java.math.BigDecimal;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */
public class Exc_191_HammingWeight {

    private int numOfOne(int n) {
        int cnt = 0;
        int flag = 1;
        while (n > 0) {
            if ((n & flag) == 1) {
                cnt++;
            }
            n >>= 1;
        }
        return cnt;
    }

    public int hammingWeight(int n) {
        int ret = 0;
        if (n > 0) {
            ret = numOfOne(n);
        } else {
            ret = 32 - numOfOne(-(n + 1));
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = Integer.parseUnsignedInt("11111111111111111111111111111101", 2);
        Exc_191_HammingWeight hw = new Exc_191_HammingWeight();
        System.out.println(hw.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
        System.out.println(hw.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000", 2)));
        System.out.println(hw.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));
        System.out.println(hw.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111100", 2)));
    }
}
