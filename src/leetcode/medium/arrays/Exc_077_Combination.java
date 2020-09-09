package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_077_Combination
 * Author:   Xu Qinkun
 * Date:     2020/3/30 10:31
 * Description:给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */

public class Exc_077_Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
//        combine(n, 1, k, lists, tempList);
        dfs(n, 1, k, lists, tempList);
        return lists;
    }

    private void combine(int n, int start, int k, List<List<Integer>> lists, List<Integer> tempList) {
        if (k == 0) {
            lists.add(new ArrayList<>(tempList));
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            combine(n, i + 1, k - 1, lists, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    private void dfs(int n, int curr, int k, List<List<Integer>> lists, List<Integer> tempList) {
        if (tempList.size() + n - curr + 1 < k)
            return;
        if (tempList.size() == k) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(curr);
        dfs(n, curr+1,k, lists, tempList);
        tempList.remove(tempList.size()-1);
        dfs(n, curr+1,k, lists, tempList);
    }

    public static void main(String[] args) {
        Exc_077_Combination com = new Exc_077_Combination();
        System.out.println(com.combine(4, 2));
    }
}
