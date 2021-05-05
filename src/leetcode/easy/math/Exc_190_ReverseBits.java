package leetcode.easy.math;

public class Exc_190_ReverseBits {

    public int reverseBits(int n) {
        byte[] data = new byte[32];
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = ~n;
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (n % 2);
            n >>= 1;
        }
        int ret = 0;
        for (int i = 0; i < data.length; i++) {
            ret = (ret << 1) + data[i];
        }
        return isNegative ? ~ret : ret;
    }

    static int M1 = 0x55555555; // 0101
    static int M2 = 0x33333333;
    static int M4 = 0x0f0f0f0f;
    static int M8 = 0x00ff00ff;

    public int reverseBits2(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    public static void main(String[] args) {
        double x = 0.1, y = 1.1;
        System.out.println(Double.toHexString(0.1));
        System.out.println(Double.toHexString(1.1));
        System.out.println(Double.toHexString(x+y));
//        Exc_190_ReverseBits rb = new Exc_190_ReverseBits();
//        System.out.println(Integer.toBinaryString(rb.reverseBits(Integer.parseUnsignedInt("4294967293"))));
//        System.out.println(Integer.toBinaryString(rb.reverseBits2(Integer.parseUnsignedInt("4294967293"))));
//        System.out.println(Integer.toBinaryString(rb.reverseBits(964176192)));
//        System.out.println(Integer.toBinaryString(rb.reverseBits2(964176192)));
//        System.out.println(Integer.toBinaryString(rb.reverseBits(0)));
//        System.out.println(Integer.toBinaryString(rb.reverseBits(-1)));
    }
}
