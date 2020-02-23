package leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Jewels and Stones
 * You're given test.strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * @author xuqin
 * @create 2018-08-05 11:02
 */
public class Exc_771_JewelInStones {

    public static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> key_num = new HashMap<>();
        for (char c : J.toCharArray()) {
            key_num.put(c, 0);
        }
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (key_num.containsKey(c)) {
                key_num.put(c, key_num.get(c) + 1);
            }
        }
        int cnt = 0;
        for (Character c :
                key_num.keySet()) {
            cnt += key_num.get(c);
        }
        return cnt;
    }

    private static void qsort(char[] src) {
        qsort(src, 0, src.length - 1);
    }

    public static int numJewelsInStones2(String J, String S) {
        int cnt = 0;
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        qsort(jewels);
        qsort(stones);
        int i = 0, j = 0;
        while (i < stones.length && j < jewels.length) {
            if (stones[i] == jewels[j]) {
                cnt++; i++;
            } else if (stones[i] < jewels[j]) {
                i++;
            } else {
                j++;
            }
        }
        return cnt;
    }

    private static int indexOfEqualChar(char[] str, char[] str2) {
        for (int i = 0, j = 0; i < str.length && j < str2.length; ) {
            if (str[i] == str2[j]) return i;
            else if (str[i] < str2[j]) i++;
            else j++;
        }
        return str.length - 1;
    }

    private static void qsort(char[] src, int low, int hi) {
        if (low >= hi) return;
        int k = partition(src, low, hi);
        qsort(src, low, k - 1);
        qsort(src, k + 1, hi);
    }

    private static int partition(char[] src, int low, int hi) {
        if (low >= hi) return low;
        int v = (low + hi) / 2;
        swap(src, v, hi);
        int p = low - 1, q = hi;
        while (true) {
            while (less(src[++p], src[hi])) if (p == hi) break;
            while (!less(src[--q], src[hi])) if (q == low) break;
            if (p >= q) break;
            swap(src, p, q);
        }
        swap(src, p, hi);
        return p;
    }

    private static boolean less(char c1, char c2) {
        return c1 - c2 < 0;
    }

    private static void swap(char[] src, int i, int j) {
        char tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones2("dbae", "bacd"));
    }
}