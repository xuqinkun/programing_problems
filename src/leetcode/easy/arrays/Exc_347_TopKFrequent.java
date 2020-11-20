package leetcode.easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exc_347_TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] freqs = new int[map.size()];
        int cur = 0;
        for (Integer key : map.keySet()) {
            freqs[cur++] = map.get(key);
        }
        int kth = topK(freqs, map.size() - k);
        int[] ret = new int[k];
        cur = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) >= kth) {
                ret[cur++] = key;
            }
            if (cur == k)
                break;
        }
        return ret;
    }

    private int topK(int[] a, int k) {
        return topK(a, k, 0, a.length - 1);
    }

    private int topK(int[] a, int k, int lo, int hi) {
        int t = partition(a, lo, hi);
        if (t == k)
            return a[t];
        if (t < k) {
            return topK(a, k, t + 1, hi);
        } else {
            return topK(a, k, lo, t - 1);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        if (lo >= hi) return lo;
        int l = lo, r = hi;
        int tmp = a[lo];
        while (l < r) {
            while (l < r && a[r] > tmp) r--;
            a[l++] = a[r];
            while (l < r && a[l] < tmp) l++;
            if (l < r)
                a[r] = a[l];
        }
        a[r] = tmp;
        return r;
    }

    public static void main(String[] args) {
        Exc_347_TopKFrequent topK = new Exc_347_TopKFrequent();
        int[] a = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topK.topKFrequent(a, 2)));
    }
}
