package leetcode.medium.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_139_WordBreak
 * Author:   Xu Qinkun
 * Date:     2020/4/2 9:20
 * Description:
 */

public class Exc_139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (dp[j] && wordDictSet.contains(subStr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Exc_139_WordBreak wb = new Exc_139_WordBreak();
        System.out.println(wb.wordBreak("aaaaaaa", Arrays.asList("aaaa","aa")));
        System.out.println(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wb.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
