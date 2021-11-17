package leetcode.medium.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exc_139_WordBreak {

    public static void main(String[] args) {
        Exc_139_WordBreak wb = new Exc_139_WordBreak();
        System.out.println(wb.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        System.out.println(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wb.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and")));
    }

    /**
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
