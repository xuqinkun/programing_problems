package leetcode.hard.dfs;

public class Exc_403_CanCross {

    public boolean canCross(int[] stones) {
        return dfs(stones, 0, 1);
    }

    private boolean dfs(int[] stones, int start, int k) {
        if (start == stones.length - 1)
            return true;
        boolean flag = false;
        for (int i = start + 1; i < stones.length; i++) {
            if (stones[start] + k == stones[i]) {
                flag = true;
                start = i;
                break;
            }
        }
        if (!flag)
            return false;
        if (k > 1 && dfs(stones, start, k - 1)
                || dfs(stones, start, k)
                || dfs(stones, start, k + 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Exc_403_CanCross cc = new Exc_403_CanCross();
        System.out.println(cc.canCross(new int[]{0, 3, 5, 6, 8, 12, 17}));
        System.out.println(cc.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(cc.canCross(new int[]{0,1,2,3,4,8,9,11}));
//        System.out.println(cc.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }
}
