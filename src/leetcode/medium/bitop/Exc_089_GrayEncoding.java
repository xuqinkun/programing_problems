package leetcode.medium.bitop;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_089_GrayEncoding
 * Author:   Xu Qinkun
 * Date:     2020/4/16 9:52
 * Description: 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 */

public class Exc_089_GrayEncoding {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(0);
        } else {
            String[] strings = grayCodeOfString(n);
            for (int i = 0; i < strings.length; i++) {
                ans.add(Integer.valueOf(strings[i], 2));
            }
        }
        return ans;
    }

    private String[] grayCodeOfString(int n) {
        int size = 1 << n;
        String[] strings = new String[size];
        if (n == 1) {
            strings[0] = "0";
            strings[1] = "1";
            return strings;
        }
        String[] last = grayCodeOfString(n - 1);
        for (int i = 0; i < last.length; i++) {
            strings[i] = "0" + last[i];
            strings[size - i - 1] = "1" + last[i];
        }
        return strings;
    }

    public static void main(String[] args) {
        Exc_089_GrayEncoding ge = new Exc_089_GrayEncoding();
        System.out.println(ge.grayCode(0));
    }
}
