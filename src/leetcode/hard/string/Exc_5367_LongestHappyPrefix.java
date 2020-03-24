package leetcode.hard.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_5367_LenghtestHappyPrefix
 * Author:   Xu Qinkun
 * Date:     2020/3/22 11:43
 * Description:最长快乐前缀
 * 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
 */

public class Exc_5367_LongestHappyPrefix {

    public String longestPrefix(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int n = chars.length;
        int [] next = new int[n];
        int i = 1, j = 0;
        next[0] = 0;
        while (i < n) {
            if (chars[i] == chars[j]) {
                j++;
                next[i] = j;
                i++;
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    next[i] = j;
                    i++;
                }
            }
        }
        return s.substring(0, next[n - 1]);
    }

    public static void main(String[] args) {
        Exc_5367_LongestHappyPrefix hp = new Exc_5367_LongestHappyPrefix();
        System.out.println(hp.longestPrefix("abc"));
        System.out.println(hp.longestPrefix("ababab"));
        System.out.println(hp.longestPrefix("leetcodeleet"));
        System.out.println(hp.longestPrefix("aaaaa"));
    }
}
