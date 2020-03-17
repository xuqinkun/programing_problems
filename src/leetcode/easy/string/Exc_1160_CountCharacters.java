package leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1160_CountCharacters
 * Author:   Xu Qinkun
 * Date:     2020/3/17 9:38
 * Description:拼写单词
 */

public class Exc_1160_CountCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = wordMap(chars);
        int count = 0;
        for (String word : words) {
            if (canSpell(word, map)) {
                count += word.length();
            }
        }
        return count;
    }

    private Map<Character, Integer> wordMap(String chars) {
        Map<Character, Integer> map = new HashMap<>();
        char[] alphabet = chars.toCharArray();
        for (char c : alphabet) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private boolean canSpell(String word, Map<Character, Integer> map) {
        Map<Character, Integer> wordMap = wordMap(word);
        for (char key : wordMap.keySet()) {
            if (!map.containsKey(key) || wordMap.get(key) > map.get(key))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Exc_1160_CountCharacters cc = new Exc_1160_CountCharacters();
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(cc.countCharacters(words, chars));
    }
}
