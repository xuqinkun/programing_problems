package leetcode.medium.math;

/**
 * Description:
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * 5 --> 2
 * 101 --> 010
 * @author xuqinkun
 * @create 2018-08-05 10:15
 **/
public class Exc_476_CompleteNumber {

    // Replace binary string
    public static int findComplement(int num) {
        String biStr = Integer.toBinaryString(num);
        StringBuffer comp = new StringBuffer();
        char[] bins = biStr.toCharArray();
        for (int i = 0; i < bins.length; i++) {
            if (bins[i] == '0') {
                comp.append('1');
            } else {
                comp.append('0');
            }
        }
        return Integer.valueOf(comp.toString(), 2);
    }

    // XOR 0 ^ 1 = 1, 1 ^ 1 = 0
    public static int findComplement2(int num) {
        int tmp = num;
        int cmp = 0;
        int i = 0;
        while (tmp != 0) {
            int cnt = (tmp & 1) ^ 1;
            cmp += cnt << i;
            tmp >>= 1;
            i++;
        }
        return cmp;
    }

    public static void main(String[] args) {
        System.out.println(findComplement2(10));
    }
}