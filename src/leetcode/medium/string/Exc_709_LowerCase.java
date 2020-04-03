package leetcode.medium.string;

import java.util.HashSet;

/**
 * Description:
 * To Lower Case
 *
 * @author xuqin
 * @create 2018-08-05 15:33
 */
public class Exc_709_LowerCase {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        HashSet<StringBuilder> set = new HashSet<>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        set.add(sb1);
        set.add(sb2);

        StringBuilder sb3 = sb1;
        sb3.append("bbb");
        System.out.println(set);
    }
}