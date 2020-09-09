package leetcode.easy.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_409_LongestPalindrome
 * Author:   Xu Qinkun
 * Date:     2020/3/19 8:58
 * Description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */

public class Exc_409_LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int count = 0;
        for (char key : map.keySet()) {
            int num = map.get(key);
            int mod = num % 2;
            count += (num - mod);
            map.put(key, mod);
        }
        for (char key : map.keySet()) {
            if (map.get(key) != 0) {
                count++;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Exc_409_LongestPalindrome lp = new Exc_409_LongestPalindrome();
        System.out.println(lp.longestPalindrome("abcde"));
    }
}
