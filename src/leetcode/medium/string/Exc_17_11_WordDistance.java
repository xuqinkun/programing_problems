package leetcode.medium.string;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_17_11_WordDistance
 * Author:   Xu Qinkun
 * Date:     2020/4/9 10:02
 * Description:
 */

public class Exc_17_11_WordDistance {

    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        if (n == 0) return 0;
        boolean word1Find = false, word2Find = false;
        int min = n, firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                word1Find = true;
                firstIndex = i;
            }
            if (words[i].equals(word2)) {
                word2Find = true;
                secondIndex = i;
            }
            if (word1Find && word2Find) {
                min = Math.min(min, Math.abs(firstIndex - secondIndex));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Exc_17_11_WordDistance wd = new Exc_17_11_WordDistance();
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        System.out.println(wd.findClosest(words, "a", "student"));
    }
}
