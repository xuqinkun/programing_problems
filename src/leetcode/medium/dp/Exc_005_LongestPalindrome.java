package leetcode.medium.dp;

public class Exc_005_LongestPalindrome {

    public static void main(String[] args) {
        Exc_005_LongestPalindrome lp = new Exc_005_LongestPalindrome();
        System.out.println(lp.longestPalindrome("ccc"));
        System.out.println(lp.longestPalindrome("eabcb"));
        System.out.println(lp.longestPalindrome("a"));
        System.out.println(lp.longestPalindrome("babad"));
        System.out.println(lp.longestPalindrome("cbbd"));
        System.out.println(lp.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandToCenter(s, i, i);
            int len2 = expandToCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandToCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
