package leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_914_CardsGroup
 * Author:   Xu Qinkun
 * Date:     2020/3/27 8:37
 * Description:
 */

public class Exc_914_CardsGroup {

    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        if (n == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        int last = map.get(it.next()), min = last;
        while (it.hasNext()) {
            int curr = map.get(it.next());
            min = Math.min(min, gcd(last, curr));
            if (min == 1) return false;
            last = curr;
        }
        return min != 1;
    }

    private int gcd(int a, int b) {
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        Exc_914_CardsGroup cc = new Exc_914_CardsGroup();
        int[] a = {1,1,2,2,2,2,2,2,3,3,4,4,4};
        System.out.println(cc.hasGroupsSizeX(a));
    }
}
