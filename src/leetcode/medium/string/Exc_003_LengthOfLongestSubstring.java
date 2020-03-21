package leetcode.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_003_LengthOfLongestSubstring
 * Author:   Xu Qinkun
 * Date:     2020/3/21 11:01
 * Description: 无重复字符的最长子串
 */

public class Exc_003_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int max = 1;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0, right = 0;
        while (right < n) {
            char c = chars[right];
            if (hash[c] != -1) {
                left = Math.max(left, hash[c] + 1);
            }
            hash[c] = right;
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        Exc_003_LengthOfLongestSubstring ls = new Exc_003_LengthOfLongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("afegrtghz"));
        System.out.println(ls.lengthOfLongestSubstring("abcdefggggggggjkslzcw"));
        System.out.println(ls.lengthOfLongestSubstring("abcabcbbefg"));
        System.out.println(ls.lengthOfLongestSubstring("bbbbbc"));
        System.out.println(ls.lengthOfLongestSubstring("pwwkefw"));
    }
}
