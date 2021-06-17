package leetcode.medium.bitop;

import java.util.Arrays;

public class Exc_1310_XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] xors = new int[n + 1];
        int[] ans = new int[m];
        xors[0] = 0;
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int left = query[0], right = query[1];
            ans[i] = xors[left] ^ xors[right + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_1310_XorQueries xr = new Exc_1310_XorQueries();
        System.out.println(Arrays.toString(xr.xorQueries(new int[] {1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}})));
    }
}
