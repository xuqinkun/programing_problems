package leetcode.medium.double_pointers;

public class Exc_680_ValidPalindrome {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) ||
                        isPalindrome(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Exc_680_ValidPalindrome vp = new Exc_680_ValidPalindrome();
        System.out.println(vp.validPalindrome("deeee"));
        System.out.println(vp.validPalindrome("bddb"));
        System.out.println(vp.validPalindrome("a"));
        System.out.println(vp.validPalindrome("ab"));
        System.out.println(vp.validPalindrome("aba"));
        System.out.println(vp.validPalindrome("acbca"));
        System.out.println(vp.validPalindrome("abca"));
        System.out.println(vp.validPalindrome("abbca"));
        System.out.println(vp.validPalindrome("adbca"));
        System.out.println(vp.validPalindrome("abc"));
    }
}
