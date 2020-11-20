package leetcode.easy.strings;

/**
 * Copyright (C), 2018-2020
 * FileName: CompressString
 * Author:   Xu Qinkun
 * Date:     2020/3/17 9:56
 * Description: 字符串压缩
 */

public class Exc_01_06_CompressString {
    public String compressString(String S) {
        if (S == null || S.isEmpty()) return S;
        char[] chars = S.toCharArray();
        StringBuilder builder = new StringBuilder();
        int n = chars.length, count = 1;
        char last = chars[0];

        builder.append(last);
        for (int i = 1; i < n; i++) {
            char c = chars[i];
            if (c != last) {
                builder.append(count);
                count = 1;
                builder.append(c);
                last = c;
            } else {
                count++;
            }
        }
        builder.append(count);
        String compressStr = builder.toString();
        if (compressStr.length() >= n)
            return S;
        return compressStr;
    }

    public static void main(String[] args) {
        Exc_01_06_CompressString cs = new Exc_01_06_CompressString();
        System.out.println(cs.compressString("aabccccc"));
    }
}
