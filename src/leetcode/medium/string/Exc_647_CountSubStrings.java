package leetcode.medium.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_647_CountSubStrings
 * Author:   Xu Qinkun
 * Date:     2020/3/23 9:23
 * Description: 回文子串
 */

public class Exc_647_CountSubStrings {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int n = chars.length, count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(chars, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(char[] chars, int from, int to) {
        for(int i = from, j = to; i <= to && j >= 0; i++, j--) {
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Exc_647_CountSubStrings css = new Exc_647_CountSubStrings();
        System.out.println(css.countSubstrings("abac"));
    }
}
