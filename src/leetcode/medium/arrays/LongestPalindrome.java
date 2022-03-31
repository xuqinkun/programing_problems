package leetcode.medium.arrays;

public class LongestPalindrome {


    public static String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        String ret = "";
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j + i < n && j <= i; j++) {
                if (s.charAt(i - j) != s.charAt(i + j))
                    break;
            }
            if (maxLen < 2 * j - 1) {
                ret = s.substring(i - j + 1, i + j);
                maxLen = 2 * j - 1;
            }
            j = 0;
            for (; j + i + 1 < n && j <= i; j++) {
                if (s.charAt(i - j) != s.charAt(i + j + 1))
                    break;
            }
            if (maxLen < j * 2) {
                ret = s.substring(i - j + 1, i + j + 1);
                maxLen = j * 2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("baabad"));
        System.out.println(longestPalindrome("ccbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }
}
