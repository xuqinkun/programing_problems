package leetcode.easy.arrays;

public class Exc_541_ReverseStr {

    public String reverseStr(String s, int k) {
        int start = 0;
        int end;
        StringBuilder builder = new StringBuilder();
        while (start < s.length()) {
            end = Math.min(s.length(), start + 2 * k) - 1;
            builder.append(reverse(s, start, end, k));
            start = end + 1;
        }
        return builder.toString();
    }

    private String reverse(String s, int start, int end, int k) {
        int n = end - start + 1;
        StringBuilder ans = new StringBuilder();
        if (n >= k) {
            for (int i = 0; i < k; i++) {
                ans.append(s.charAt(start + k - i - 1));
            }
            for (int i = 0; i < k && start + k + i <= end; i++) {
                ans.append(s.charAt(start + k + i));
            }
        } else {
            for (int i = end; i >= start; i--) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Exc_541_ReverseStr rs = new Exc_541_ReverseStr();
        System.out.println(rs.reverseStr("abcdefg", 2));
        System.out.println(rs.reverseStr("abcd", 2));
        System.out.println(rs.reverseStr("abcde", 2));
        System.out.println(rs.reverseStr("abcde", 3));
        System.out.println(rs.reverseStr("abc", 3));
        System.out.println(rs.reverseStr("ab", 3));
        System.out.println(rs.reverseStr("a", 3));
    }
}
