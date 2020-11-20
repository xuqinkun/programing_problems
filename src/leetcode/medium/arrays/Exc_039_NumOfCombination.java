package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exc_039_NumOfCombination {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> tempList = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0, lists, tempList);
        return lists;
    }

    private void combinationSum(int[] candidates, int len, int start, int target, ArrayList<Integer> tempList, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < len; i++) {
            if (target - candidates[i] < 0) break;
            tempList.add(candidates[i]);
            combinationSum(candidates, len, i, target - candidates[i], tempList, lists);
            tempList.remove(tempList.size() - 1);
        }
    }

    private void dfs(int[] candidates, int curr, int target, int sum, List<List<Integer>> lists, List<Integer> temp) {
        if (sum == target) {
            lists.add(new ArrayList<>(temp));
            return;
        }
        if (sum < target) {
            temp.add(candidates[curr]);
            sum += candidates[curr];
            dfs(candidates, curr, target, sum, lists, temp);
            Integer last = temp.remove(temp.size() - 1);
            sum -= last;
            if (curr + 1 < candidates.length && sum + candidates[curr + 1] <= target)
                dfs(candidates, curr + 1, target, sum, lists, temp);
        }
    }

    public static void main(String[] args) {
        Exc_039_NumOfCombination nc = new Exc_039_NumOfCombination();
        int[] candidates = {21, 46, 35, 20, 44, 31, 29, 23, 45, 37, 33, 34, 39, 42, 24, 40, 41, 26, 22, 38, 36, 27, 25, 49, 48, 43};
//        int[] candidates = {2, 3, 5};
        System.out.println(nc.combinationSum(candidates, 51));
    }
}
