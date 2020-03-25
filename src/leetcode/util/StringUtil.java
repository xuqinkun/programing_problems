package leetcode.util;

/**
 * Copyright (C), 2018-2020
 * FileName: StringUtil
 * Author:   Xu Qinkun
 * Date:     2020/3/25 8:53
 * Description:
 */

public class StringUtil {

    public static int[][] stringToArray(String str) {
        String newStr = str.replace("[", "");
        newStr = newStr.substring(0, newStr.length() - 1);
        String[] tokens = newStr.split("]");
        int row = tokens.length, col = tokens[0].split(",").length;
        int[][] ans = new int[row][col];
        int i = 0, j;
        for (String token : tokens) {
            String[] arr = token.split(",");
            j = 0;
            for (String s : arr) {
                if (!s.trim().isEmpty())
                    ans[i][j++] = Integer.parseInt(s.trim());
            }
            i++;
        }
        return ans;
    }
}
