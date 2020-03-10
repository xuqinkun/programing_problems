package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exc_039_NumOfCombination {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> tempList = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        int len = candidates.length;
        combinationSum(candidates, len, 0, target, tempList, lists);
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
            //combinationSum(candidates, i + 1, target, tempList, lists);
        }
    }

    public static void main(String[] args) {
        Exc_039_NumOfCombination nc = new Exc_039_NumOfCombination();
        int[] candidates = {21,46,35,20,44,31,29,23,45,37,33,34,39,42,24,40,41,26,22,38,36,27,25,49,48,43};
        int target = 71;
        System.out.println(nc.combinationSum(candidates, target));
    }
}
