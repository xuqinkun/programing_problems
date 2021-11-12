package leetcode.easy.dp;

public class Exc_746_MinCostClimbingStairs {

    public static void main(String[] args) {
        Exc_746_MinCostClimbingStairs mcc = new Exc_746_MinCostClimbingStairs();
        System.out.println(mcc.minCostClimbingStairs(new int[]{10, 15}));
        System.out.println(mcc.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(mcc.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(mcc.minCostClimbingStairs(new int[]{1, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] costs = new int[len + 1];
        costs[0] = cost[0];
        costs[1] = cost[1];

        for (int i = 2; i < len; i++) {
            costs[i] = Math.min(costs[i - 2], costs[i - 1]) + cost[i];
        }
        costs[len] = Math.min(costs[len - 2], costs[len - 1]);
        return costs[len];
    }
}
