package leetcode.hard.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_887_SuperEggDrop
 * Author:   Xu Qinkun
 * Date:     2020/4/11 9:13
 * Description:
 */

public class Exc_887_SuperEggDrop {
    Map<Integer, Integer> map = new HashMap<>();

    public int superEggDrop(int K, int N) {
        if (!map.containsKey(K + N * 100)) {
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1)
                ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = superEggDrop(K - 1, x - 1);
                    int t2 = superEggDrop(K, N - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else
                        lo = hi = x;
                }
                ans = 1 + Math.min(Math.max(superEggDrop(K - 1, lo - 1), superEggDrop(K, N - lo))
                        , Math.max(superEggDrop(K - 1, hi - 1), superEggDrop(K, N - hi)));
            }
            map.put(K + N * 100, ans);
        }
        return map.get(K + N * 100);
    }

    public static void main(String[] args) {
        Exc_887_SuperEggDrop se = new Exc_887_SuperEggDrop();
        System.out.println(se.superEggDrop(3, 20));
    }
}
