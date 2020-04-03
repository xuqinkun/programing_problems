package leetcode.medium.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_008_StringToInteger
 * Author:   Xu Qinkun
 * Date:     2020/4/3 8:43
 * Description:
 */

public class Exc_008_StringToInteger {
    private final static long ABS_MIN_VAL = 1L << 31;

    public int myAtoi(String str) {
        if (str == null || str.trim().isEmpty())
            return 0;
        long ans = 0;
        boolean isNegative = false;
        int n = str.length(), i = 0;
        while (i < n) {
            char c = str.charAt(i);
            if (isNum(c)) {
                isNegative = i > 0 && str.charAt(i - 1) == '-';
                while (i < n && ans <= ABS_MIN_VAL) {
                    c = str.charAt(i);
                    if (c < '0' || c > '9')
                        break;
                    ans = ans * 10 + (c - '0');
                    i++;
                }
                break;
            } else if (c != ' ' && c != '-' && c != '+') {
                return 0;
            } else if ((c == '-' || c == '+') && i < n - 1 && !isNum(str.charAt(i + 1))) {
                return 0;
            }
            i++;
        }
        if (isNegative) {
            if (ans > ABS_MIN_VAL)
                return Integer.MIN_VALUE;
            else
                return (int) (-ans);
        }
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) ans;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Exc_008_StringToInteger atoi = new Exc_008_StringToInteger();
        System.out.println(atoi.myAtoi(" "));
        System.out.println(atoi.myAtoi("42"));
        System.out.println(atoi.myAtoi(" -42"));
        System.out.println(atoi.myAtoi("4193 with words"));
        System.out.println(atoi.myAtoi("words and 987"));
        System.out.println(atoi.myAtoi("-91283472332"));
        System.out.println(atoi.myAtoi("-2147483648"));
        System.out.println(atoi.myAtoi("2147483648"));
        System.out.println(atoi.myAtoi("2147483647"));
        System.out.println(atoi.myAtoi("+-2"));
    }
}
