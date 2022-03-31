package leetcode.medium.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exc_049_GroupAnagrams {

    public static void main(String[] args) {
        Exc_049_GroupAnagrams ga = new Exc_049_GroupAnagrams();
        System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(ga.groupAnagrams(new String[]{"a"}));
        System.out.println(ga.groupAnagrams(new String[]{""}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String token = strs[i];
            char[] entry = new char[26];
            for (int j = 0; j < token.length(); j++) {
                int c = token.charAt(j) - 'a';
                entry[c]++;
            }
            StringBuilder keyStr = new StringBuilder();
            for (int j = 0; j < entry.length; j++) {
                keyStr.append((char) ('a' + entry[j]));
            }
            String key = keyStr.toString();
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(token);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
