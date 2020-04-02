package leetcode.medium.string;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1111_ValidBracketDepth
 * Author:   Xu Qinkun
 * Date:     2020/4/1 11:13
 * Description: 有效括号的嵌套深度
 */

public class Exc_1111_ValidBracketDepth {

    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int n = chars.length, d = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == '(') {
                d++;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                d--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_1111_ValidBracketDepth vd = new Exc_1111_ValidBracketDepth();
        System.out.println(Arrays.toString(vd.maxDepthAfterSplit("()(())()")));
    }
}
