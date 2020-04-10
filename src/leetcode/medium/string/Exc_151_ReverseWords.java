package leetcode.medium.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_151_ReverseWords
 * Author:   Xu Qinkun
 * Date:     2020/4/10 9:23
 * Description:给定一个字符串，逐个翻转字符串中的每个单词。
 */

public class Exc_151_ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) return "";
        int i = 0, j = 0, n = s.length();
        char[] chars = s.toCharArray();
        while (i < n) {
            while (i < n && chars[i] == ' ') i++;
            if (i == n) {
                j--;
                break;
            }
            while (i < n && chars[i] != ' ')
                chars[j++] = chars[i++];
            if (i < n && j < n)
                chars[j++] = ' ';
        }
        reverse(chars, 0, j - 1);
        i = 0;
        for (int k = 0; k < j; k++) {
            while (k < j && chars[k] != ' ') k++;
            reverse(chars, i, k - 1);
            k++;
            i = k;
        }
        return new String(chars, 0, j);
    }

    private void reverse(char[] chars, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start; i <= mid; i++) {
            char c = chars[i];
            chars[i] = chars[end - i + start];
            chars[end - i + start] = c;
        }
    }

    public static void main(String[] args) {
        Exc_151_ReverseWords rw = new Exc_151_ReverseWords();
        System.out.println("*" + rw.reverseWords("the sky is blue") + "*");
        System.out.println("*" + rw.reverseWords("  hello world!  ") + "*");
        System.out.println("*" + rw.reverseWords("a good   example") + "*");
        System.out.println("*" + rw.reverseWords(" ") + "*");
    }
}
