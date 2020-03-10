package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exc_040_NumOfCombinationNoRepeat {

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
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            tempList.add(candidates[i]);
            combinationSum(candidates, len, i + 1, target - candidates[i], tempList, lists);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Exc_040_NumOfCombinationNoRepeat nc = new Exc_040_NumOfCombinationNoRepeat();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(nc.combinationSum(candidates, target));
    }
}
