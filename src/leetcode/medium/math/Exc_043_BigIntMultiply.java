package leetcode.medium.math;

public class Exc_043_BigIntMultiply {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null
                || num1.isEmpty() || num2.isEmpty()
                || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int m = a.length, n = b.length;
        int x, y, z, carry = 0, t;
        int[] c = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            x = a[i] - '0';
            for (int j = n - 1; j >= 0; j--) {
                 y = b[j] - '0';
                 z = x * y;
                int idx = m + n - i - j - 2;
                t = c[idx] + (z % 10);
                carry = t / 10;
                c[idx] = t % 10;
                t = c[idx + 1] + (z / 10) + carry;
                carry = t / 10;
                c[idx + 1] = t % 10;
                if (carry > 0 && idx + 2 <= m + n - 1) {
                    c[idx + 2] += carry;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int k = c.length - 1;
        while (c[k] == 0) {
            k--;
        }
        while (k >= 0) {
            sb.append(c[k--]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Exc_043_BigIntMultiply bm = new Exc_043_BigIntMultiply();
        System.out.println(bm.multiply("123", "456"));
    }
}
