package leetcode.medium.dfs;

import java.util.Stack;

public class Exc_743_NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = -1;
            }
        }
        for (int i = 0; i < times.length; i++) {
            int from = times[i][0], to = times[i][1];
            graph[from][to] = times[i][2];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int cnt = 0;
        while (!stack.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (graph[k][i] != -1) {
                }
            }
        }
        return 0;
    }
}
