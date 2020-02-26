package newcode.swordtooffer;

public class Exc_43_NumOfDigitOne {

    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += digitOne(i);
        }
        return count;
    }

    private int digitOne(int i) {
        int cnt = 0;
        while (i != 0) {
            if (i % 10 == 1) {
                cnt++;
            }
            i /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Exc_43_NumOfDigitOne nd = new Exc_43_NumOfDigitOne();
        System.out.println(nd.countDigitOne(20));
    }
}
