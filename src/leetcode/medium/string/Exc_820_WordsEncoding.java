package leetcode.medium.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_820_WordsEncoding
 * Author:   Xu Qinkun
 * Date:     2020/3/28 8:38
 * Description: 单词的压缩编码
 */

public class Exc_820_WordsEncoding {

    static class WordTreeNode {
        WordTreeNode [] children;
        int count;

        public WordTreeNode() {
            children = new WordTreeNode[26];
            count = 0;
        }

        public WordTreeNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new WordTreeNode();
                count++;
            }
            return children[c - 'a'];
        }
    }

    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        if (n == 0) return 0;

        WordTreeNode root = new WordTreeNode();
        Map<WordTreeNode, Integer> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();
            WordTreeNode curr = root;
            for (int j = len - 1; j >= 0; j--) {
                curr = curr.get(word.charAt(j));
            }
            nodes.put(curr, i);
        }
        int count = 0;
        for (WordTreeNode node : nodes.keySet()) {
            if (node.count == 0)
                count += words[nodes.get(node)].length() + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Exc_820_WordsEncoding we = new Exc_820_WordsEncoding();
        String[] words = {"time", "ime", "me", "e", "bell", "ell", "student", "dente"};
        System.out.println(we.minimumLengthEncoding(words));
    }
}
