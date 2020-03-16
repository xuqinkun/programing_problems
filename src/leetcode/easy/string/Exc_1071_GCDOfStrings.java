package leetcode.easy.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1071
 * Author:   Xu Qinkun
 * Date:     2020/3/16 10:19
 * Description: 字符串的最大公因子
 */

public class Exc_1071_GCDOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) return "";
        int len1 = str1.length(), len2 = str2.length();
        if (len1 == 0 || len2 == 0) return "";
        int gcd = gcd(len1, len2);
        String prefix = str1.substring(0, gcd);
        if (isGcdStr(str1, prefix) && isGcdStr(str2, prefix)) return prefix;
        return "";
    }

    private boolean isGcdStr(String str, String subStr) {
        int from = 0, to = subStr.length();
        while (to <= str.length()) {
            if (!subStr.equals(str.substring(from ,to)))
                return false;
            from = to;
            to += subStr.length();
        }
        return from == str.length();
    }

    private int gcd(int m, int n) {
        int r;
        while ((r = m % n) != 0) {
            m = n;
            n = r;
        }
        return n;
    }

    public static void main(String[] args) {
        Exc_1071_GCDOfStrings gs = new Exc_1071_GCDOfStrings();
        System.out.println(gs.gcdOfStrings("aaaaaa", "aa"));
    }
}
