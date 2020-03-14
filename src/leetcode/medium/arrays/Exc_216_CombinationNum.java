package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

public class Exc_216_CombinationNum {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum(k, n, 1, lists, temp);
        return lists;
    }

    private void combinationSum(int k, int sum, int start, List<List<Integer>> lists, List<Integer> temp) {
        if (sum < 0) return;
        if (sum == 0) {
            if (temp.size() == k) {
                lists.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = start; i <= 9 && sum >= i; i++) {
            temp.add(i);
            combinationSum(k, sum - i, i + 1, lists, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Exc_216_CombinationNum cn = new Exc_216_CombinationNum();
        System.out.println(cn.combinationSum3(3, 9));
    }
}
