package leetcode.medium.double_pointers;

import java.util.Arrays;
import java.util.List;

public class Exc_524_FindLongestWord {

    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String d: dictionary) {
            int l1 = d.length();
            int l2 = longestWord.length();
            if (l1 < l2 || (l1 == l2 && longestWord.compareTo(d) < 0)) {
                continue;
            }
            if (isSubStr(s, d)) {
                longestWord = d;
            }
        }
        return longestWord;
    }

    private boolean isSubStr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            char c1 = s.charAt(i);
            char c2 = target.charAt(j);
            if (c1 == c2) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        Exc_524_FindLongestWord fl = new Exc_524_FindLongestWord();
        List<String> list = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(fl.findLongestWord("abpcplea", list));
        list = Arrays.asList("a", "b", "c");
        System.out.println(fl.findLongestWord("abpcplea", list));
    }
}
