package newcode.kaoyanfushi;

public class IntegerSplit {
    
    public int split(int n) {
        int []dp = new int[n + 1];
        int exp = 19;
        int []base = new int[exp];

        for (int i = 0, j = 1; i < exp; i++, j <<= 1) {
            base[i] = j;
        }
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = base[i - 1]; j <= n; j++) {
                dp[j] += dp[j - base[i - 1]];
                dp[j] %= 1000000;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerSplit is = new IntegerSplit();
        System.out.println(is.split(4));
    }
}
