package leetcode.medium.dfs;

public class Exc_91_NumDecodings {

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) > '0' &&
//                    s.charAt(i - 2) <= '2' && s.charAt(i - 1) <= '6') { 17 18 19
                    (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                System.out.println(s.charAt(i-2) + " " + s.charAt(i-1));
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }


    public static void main(String[] args) {
        Exc_91_NumDecodings nd = new Exc_91_NumDecodings();
//        System.out.println(nd.numDecodings("0"));
//        System.out.println(nd.numDecodings("06"));
//        System.out.println(nd.numDecodings("1110"));
        System.out.println(nd.numDecodings("2611055971756562"));
    }
}
