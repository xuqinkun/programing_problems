package newcode.swordtooffer;

import java.util.Arrays;

public class MathOp {

    public int cutRope(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;
        int mod = target % 3, divid = target / 3;
        if (mod == 0) {
            return pow(3, divid);
        }
        else if (mod == 1) {
            return 2 * 2 * pow(3, divid - 1);
        }
        else {
            return 2 * pow(3, divid);
        }
    }

    private int pow(int n, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return n;
        int x = n;
        boolean isOdd = exp % 2 != 0;
        while (exp > 1) {
            x *= x;
            exp >>= 1;
        }
        if (isOdd) {
            x *= n;
        }
        return x;
    }



    public static void main(String[] args) {

    }
}
